package bt.com.sdi.resilient.sdigateway.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name="feature-retriever", url="feature-retriever:8080")
public interface FeatureRetrieverProxy {
    @GetMapping("/features/")
    @ResponseBody
    ResponseEntity getAll();

    @GetMapping("/features/{id}")
    @ResponseBody ResponseEntity get(@PathVariable() String id);

    @GetMapping("/features/resource/{id}")
    @ResponseBody String getResource(@PathVariable() String id);
}
