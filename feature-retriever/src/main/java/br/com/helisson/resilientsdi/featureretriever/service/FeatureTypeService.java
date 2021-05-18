package br.com.helisson.resilientsdi.featureretriever.service;

import br.com.helisson.resilientsdi.featureretriever.domain.BoundBox;
import br.com.helisson.resilientsdi.featureretriever.domain.FeatureType;
import br.com.helisson.resilientsdi.featureretriever.repository.FeatureTypeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import java.net.URI;

@Service
public class FeatureTypeService {

    private Logger logger = LoggerFactory.getLogger(FeatureTypeService.class);

    @Autowired
    private FeatureTypeRepository featureTypeRepository;

    public RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "default", fallbackMethod = "fallback")
    @Retry(name = "default", fallbackMethod = "fallback")
    public String getFeatureResource(String id) {
        FeatureType featureType = featureTypeRepository.getOne(id);

        return this.tries(
                this.buildResource(
                        featureType.getService().getWmsUrl(),
                        featureType.getName(),
                        new BoundBox(
                                featureType.getXMin(),
                                featureType.getYMin(),
                                featureType.getXMax(),
                                featureType.getYMax())
                )
        );
    }

    public String fallback(String id, Exception e) {
        logger.warn("Entering in fallback method");

        URI uri = URI.create("http://service-finder:8080/similar/feature-types/"+id);
        return this.restTemplate.getForObject(uri, String.class);
    }

    private String buildResource(String wmsResource, String featureName, BoundBox boundBox) {
        StringBuilder wmsUrl = new StringBuilder(wmsResource);

        if (!wmsResource.contains("?")) {
            wmsUrl.append("?");
        } else {
            wmsUrl.append("&");
        }

        wmsUrl.append("layers=").append(featureName);

        wmsUrl.append("&request=GetMap")
                .append("&srs=EPSG:4326")
                .append("&format=application/openlayers");

        wmsUrl.append("&HEIGHT=1000&WIDTH=1000");

        wmsUrl.append("&BBOX=")
                .append(boundBox.getBoundBoxString());

        logger.info("Building url: {} for feature {}", wmsUrl.toString(), featureName);

        return wmsUrl.toString();
    }

    private String tries(String resource) {
        logger.info("Trying resource: {}", resource);

        URI uri = URI.create(resource);
        try {
            this.restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            logger.error(e.getMessage());

            throw e;
        }

        return resource;
    }
}
