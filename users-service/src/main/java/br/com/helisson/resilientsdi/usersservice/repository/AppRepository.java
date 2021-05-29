package br.com.helisson.resilientsdi.usersservice.repository;

import br.com.helisson.resilientsdi.usersservice.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<App, String> {
}
