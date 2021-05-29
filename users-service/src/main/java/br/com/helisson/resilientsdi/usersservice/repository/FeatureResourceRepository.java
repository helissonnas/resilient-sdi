package br.com.helisson.resilientsdi.usersservice.repository;

import br.com.helisson.resilientsdi.usersservice.domain.FeatureResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureResourceRepository extends JpaRepository<FeatureResource, String> {
}
