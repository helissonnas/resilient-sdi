package bt.com.sdi.resilient.sdigateway.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class FeatureService {

    public RestTemplate restTemplate = new RestTemplate();

    @HystrixCommand(fallbackMethod = "reliable")
    public String getFeature(String id) {
        URI uri = URI.create("http://feature-retriever:8080/features/resource/" + id);
        return this.restTemplate.getForObject(uri, String.class);
    }

    /**
     * Method for connection with the feature finder service
     * @param id
     * @return
     */
    public String reliable(String id) {
        URI uri = URI.create("http://localhost:5000/similar/feature-types/"+id);
        return this.restTemplate.getForObject(uri, String.class);
    }

}
