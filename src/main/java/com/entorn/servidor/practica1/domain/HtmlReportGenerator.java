package com.entorn.servidor.practica1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HtmlReportGenerator implements ReportGenerator {

    private ReportJobFactory reportJobFactory;

    @Autowired
    public HtmlReportGenerator(ReportJobFactory reportJobFactory) {
        this.reportJobFactory = reportJobFactory;
    }

    @Override
    public String generarInforme() {
        return "INFORME HTML: " + this.reportJobFactory.createReportJob().getId();
    }

    @Override
    public String getId() {
        return this.reportJobFactory.createReportJob().getId();
    }
}
