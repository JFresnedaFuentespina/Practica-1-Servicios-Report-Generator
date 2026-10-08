package com.entorn.servidor.practica1.domain;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportJobFactory {
    public final ObjectProvider<ReportJob> provider;

    @Autowired
    public ReportJobFactory(ObjectProvider<ReportJob> provider) {
        this.provider = provider;
    }

    public ReportJob createReportJob() {
        return this.provider.getObject();
    }
}
