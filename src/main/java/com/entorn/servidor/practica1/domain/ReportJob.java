package com.entorn.servidor.practica1.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class ReportJob {
    private UUID id = UUID.randomUUID();

    public void setId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return this.id.toString();
    }
}
