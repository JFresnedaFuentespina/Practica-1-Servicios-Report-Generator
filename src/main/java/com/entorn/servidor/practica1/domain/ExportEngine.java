package com.entorn.servidor.practica1.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Lazy
public class ExportEngine {

    public ExportEngine() {
        System.out.println("Constructor ExportEngine inicializando...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Constructor ExportEngine inicializado!");
    }

    public void showCache(HashMap<String, String> reports) {
        reports.forEach((id, type) -> {
            System.out.println("Informe: " + id + " tipo: " + type);
        });
    }
}
