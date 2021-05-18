package br.com.helisson.servicefinder.controller;

import br.com.helisson.servicefinder.service.FeatureFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureFinderController {
    @Autowired
    private FeatureFinderService featureFinderService;

    @GetMapping("/similar/feature-types/{id}")
    public String getSimilarFeatureTypes(@PathVariable String id) {
        return featureFinderService.findSimilar(id);
    }
}
