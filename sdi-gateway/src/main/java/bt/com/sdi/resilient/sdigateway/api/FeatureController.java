package bt.com.sdi.resilient.sdigateway.api;

import bt.com.sdi.resilient.sdigateway.proxy.FeatureRetrieverProxy;
import bt.com.sdi.resilient.sdigateway.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/feature-retriever")
public class FeatureController {
    @Autowired
    private FeatureRetrieverProxy featureRetrieverProxy;

    @GetMapping("/features/")
    public @ResponseBody
    ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(featureRetrieverProxy.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/features/{id}")
    public @ResponseBody ResponseEntity get(@PathVariable() String id) {
        try {
            return new ResponseEntity<>(featureRetrieverProxy.get(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/features/resource/{id}")
    public @ResponseBody String getResource(@PathVariable() String id) {
        try {
            return featureRetrieverProxy.getResource(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
