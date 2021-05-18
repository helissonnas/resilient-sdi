package br.com.helisson.servicefinder.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name="api-search-engine", url="localhost:5000")
public interface ApiSearchEngineProxy {
    @GetMapping("/similar/feature-types/{id}")
    public @ResponseBody
    List similarFeatures(@PathVariable String id);

    @GetMapping("/find/feature-type/bounding-box")
    public @ResponseBody
    ResponseEntity similarFeaturesByBoundingBox(@RequestBody SearchEngineRequestDto engineRequest);
}
