package com.entorn.servidor.practica1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Primary
public class PdfReportGenerator implements ReportGenerator {

    private final ReportJobFactory reportJobFactory;
    private ReportJob reportJob;

    @Autowired
    public PdfReportGenerator(ReportJobFactory reportJobFactory) {
        this.reportJobFactory = reportJobFactory;
    }

    @Override
    public String generarInforme() {
        reportJob = reportJobFactory.createReportJob();
        return "INFORME PDF: " + reportJob.getId();
    }

    @Override
    public String getId() {
        return reportJob.getId();
    }
}
