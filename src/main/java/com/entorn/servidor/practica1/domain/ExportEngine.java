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

    public String showCache(HashMap<String, String> reports) {
        StringBuilder cache = new StringBuilder();

        reports.forEach((id, type) -> {
            cache.append("Informe ")
                    .append(id)
                    .append(" tipo ")
                    .append(type)
                    .append("\n");
        });

        return cache.toString();
    }
}
