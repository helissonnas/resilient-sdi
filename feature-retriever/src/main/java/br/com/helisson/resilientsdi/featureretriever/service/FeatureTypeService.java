package br.com.helisson.resilientsdi.featureretriever.service;

import br.com.helisson.resilientsdi.featureretriever.domain.FeatureType;
import br.com.helisson.resilientsdi.featureretriever.repository.FeatureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class FeatureTypeService {

    @Autowired
    private FeatureTypeRepository featureTypeRepository;

    public RestTemplate restTemplate = new RestTemplate();


    public String getFeatureResource(String id) {
        FeatureType featureType = featureTypeRepository.getOne(id);

        return this.tries(
                this.buildResource(
                        featureType.getService().getWfsUrl(),
                        featureType.getName()
                )
        );
    }

    public String reliable(String id) {
        URI uri = URI.create("http://api_search_engine:8080/similar/feature-types/"+id);
        return this.restTemplate.getForObject(uri, String.class);
    }

    private String buildResource(String wfsResource, String featureName) {
        String wfsUrl = wfsResource;
        wfsUrl = wfsUrl.replaceAll("layers=[^&]*", "layers=" + featureName);
        wfsUrl = wfsUrl + "&request=GetMap&srs=EPSG:4326&format=application/openlayers";

        return wfsUrl;
    }

    private String tries(String resource) {
        URI uri = URI.create(resource);
        try {
            this.restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            throw e;
        }

        return resource;
    }
}
