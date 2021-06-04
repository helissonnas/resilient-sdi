package br.com.helisson.servicefinder.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name="api-search-engine", url="host.docker.internal:5000")
public interface ApiSearchEngineProxy {
    @GetMapping("/similar/feature-types/{id}")
    public @ResponseBody
    List<Map<String, Object>> similarFeatures(@PathVariable String id);

    @PostMapping("/find/feature-type/bounding-box")
    public @ResponseBody
    List similarFeaturesByBoundingBox(@RequestBody SearchEngineRequestDto engineRequest);
}
