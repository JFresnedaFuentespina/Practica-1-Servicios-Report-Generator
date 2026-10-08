package com.entorn.servidor.practica1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HtmlReportGenerator implements ReportGenerator {

    private final ReportJobFactory reportJobFactory;
    private ReportJob reportJob;

    @Autowired
    public HtmlReportGenerator(ReportJobFactory reportJobFactory) {
        this.reportJobFactory = reportJobFactory;
    }

    @Override
    public String generarInforme() {
        reportJob = reportJobFactory.createReportJob();
        return "INFORME HTML: " + reportJob.getId();
    }

    @Override
    public String getId() {
        return reportJob.getId();
    }
}
