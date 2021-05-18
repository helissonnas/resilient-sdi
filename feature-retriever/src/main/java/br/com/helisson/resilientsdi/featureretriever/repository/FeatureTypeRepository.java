package br.com.helisson.resilientsdi.featureretriever.repository;

import br.com.helisson.resilientsdi.featureretriever.domain.FeatureType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureTypeRepository extends JpaRepository<FeatureType, String> {
}
