package br.com.helisson.resilientsdi.usersservice.repository;

import br.com.helisson.resilientsdi.usersservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
