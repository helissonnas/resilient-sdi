package br.com.helisson.resilientsdi.usersservice.repository;

import br.com.helisson.resilientsdi.usersservice.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, String> {
}
