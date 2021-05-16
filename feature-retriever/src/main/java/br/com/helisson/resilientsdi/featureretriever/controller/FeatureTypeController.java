package br.com.helisson.resilientsdi.featureretriever.controller;

import br.com.helisson.resilientsdi.featureretriever.domain.FeatureType;
import br.com.helisson.resilientsdi.featureretriever.repository.FeatureTypeRepository;
import br.com.helisson.resilientsdi.featureretriever.service.FeatureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("features")
public class FeatureTypeController {

    @Autowired
    private FeatureTypeRepository featureTypeRepository;

    @Autowired
    private FeatureTypeService featureTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(featureTypeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, name = "/{id}")
    public @ResponseBody ResponseEntity get(@PathVariable() String id) {
        try {
            return new ResponseEntity<>(featureTypeRepository.getOne(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(method = RequestMethod.GET, name = "/resource/{id}")
    public @ResponseBody ResponseEntity getResource(@PathVariable() String id) {
        try {
            return new ResponseEntity<>(featureTypeService.getFeatureResource(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
