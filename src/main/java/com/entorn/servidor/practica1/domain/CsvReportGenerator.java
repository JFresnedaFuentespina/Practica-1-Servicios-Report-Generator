package com.entorn.servidor.practica1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CsvReportGenerator implements ReportGenerator {
    private final ReportJobFactory reportJobFactory;

    @Autowired
    public CsvReportGenerator(ReportJobFactory reportJob) {
        this.reportJobFactory = reportJob;
    }


    @Override
    public String generarInforme() {
        return "INFORME CSV: " + this.reportJobFactory.createReportJob().getId();
    }

    @Override
    public String getId() {
        return this.reportJobFactory.createReportJob().getId();
    }
}
