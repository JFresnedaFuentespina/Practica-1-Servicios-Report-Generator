package com.entorn.servidor.practica1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Primary
public class PdfReportGenerator implements ReportGenerator {

    private final ReportJobFactory reportJobFactory;

    @Autowired
    public PdfReportGenerator(ReportJobFactory reportJob) {
        this.reportJobFactory = reportJob;
    }

    @Override
    public String generarInforme() {
        return "INFORME PDF: " + this.reportJobFactory.createReportJob().getId();
    }

    @Override
    public String getId() {
        return this.reportJobFactory.createReportJob().getId();
    }
}
