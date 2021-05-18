package br.com.helisson.resilientsdi.featureretriever.controller;

import br.com.helisson.resilientsdi.featureretriever.repository.FeatureTypeRepository;
import br.com.helisson.resilientsdi.featureretriever.service.FeatureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeatureTypeController {

    @Autowired
    private FeatureTypeRepository featureTypeRepository;

    @Autowired
    private FeatureTypeService featureTypeService;

    @GetMapping("/features/")
    public @ResponseBody
    ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(featureTypeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/features/{id}")
    public @ResponseBody ResponseEntity get(@PathVariable() String id) {
        try {
            return new ResponseEntity<>(featureTypeRepository.getOne(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/features/resource/{id}")
    public @ResponseBody String getResource(@PathVariable() String id) {
        try {
            return featureTypeService.getFeatureResource(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
