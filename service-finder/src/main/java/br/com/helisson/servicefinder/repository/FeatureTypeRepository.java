package br.com.helisson.servicefinder.repository;

import br.com.helisson.servicefinder.domain.FeatureType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureTypeRepository extends JpaRepository<FeatureType, String> {
}

