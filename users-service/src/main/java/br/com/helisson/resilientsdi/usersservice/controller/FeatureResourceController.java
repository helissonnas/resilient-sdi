package br.com.helisson.resilientsdi.usersservice.controller;

import br.com.helisson.resilientsdi.usersservice.domain.FeatureResource;
import br.com.helisson.resilientsdi.usersservice.repository.FeatureResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feature-resource")
public class FeatureResourceController extends BaseController<FeatureResource> {

    @Autowired
    private FeatureResourceRepository featureResourceRepository;

    @Override
    JpaRepository<FeatureResource, String> getRepository() {
        return featureResourceRepository;
    }
}
