package br.com.helisson.servicefinder.service;

import br.com.helisson.servicefinder.proxy.ApiSearchEngineProxy;
import br.com.helisson.servicefinder.proxy.SearchEngineRequestDto;
import br.com.helisson.servicefinder.proxy.UsersServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureFinderService {
    private Logger logger = LoggerFactory.getLogger(FeatureFinderService.class);

    @Autowired
    private ApiSearchEngineProxy apiSearchEngineProxy;

    @Autowired
    private UsersServiceProxy usersServiceProxy;

    public String findSimilar(String id) {
        List<String> similars = apiSearchEngineProxy.similarFeatures(id);

        usersServiceProxy.report("admin", id, "soils_brazil_wrb_wgs84");

        if (!similars.isEmpty()) {
            return similars.get(0);
        }

        return "http://geoinfo.cnps.embrapa.br/geoserver/geonode/wms?layers=soils_brazil_wrb_wgs84&request=GetMap&srs=EPSG:4326&format=application/openlayers&HEIGHT=1000&WIDTH=1000&BBOX=-73.98,-33.75,-34.82,5.25";
    }

    private String buildResource(String wmsResource, String featureName, SearchEngineRequestDto boundBox) {
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

        wmsUrl.append("&BBOX=")
                .append(boundBox.getBoundBoxString());

        logger.info("Building url: {} for feature {}", wmsUrl.toString(), featureName);

        return wmsUrl.toString();
    }
}
