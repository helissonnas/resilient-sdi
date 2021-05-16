package br.com.helisson.resilientsdi.featureretriever.repository;

import br.com.helisson.resilientsdi.featureretriever.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, String> {
}
