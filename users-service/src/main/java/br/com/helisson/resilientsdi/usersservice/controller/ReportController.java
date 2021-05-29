package br.com.helisson.resilientsdi.usersservice.controller;

import br.com.helisson.resilientsdi.usersservice.domain.Report;
import br.com.helisson.resilientsdi.usersservice.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController extends BaseController<Report> {

    @Autowired
    private ReportRepository reportRepository;


    @Override
    JpaRepository<Report, String> getRepository() {
        return reportRepository;
    }
}
