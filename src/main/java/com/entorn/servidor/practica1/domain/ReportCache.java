package com.entorn.servidor.practica1.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ReportCache {
    HashMap<String, String> reports = new HashMap<>(); //* ID, TIPO

    public void addReport(String id, String type) {
        System.out.println("Añadiendo informe: " + id + " " + type);
        reports.put(id, type);
    }

    public void clearReports() {
        System.out.println("Limpiando cache...");
        reports.clear();
    }

    public void initReports() {
        System.out.println(">> Inicializando cache...");
        addReport("1234", "HTML");
        addReport("5678", "PDF");
        addReport("9ABC", "CSV");
        System.out.println(">> Cache inicializado!");
    }

    public HashMap<String, String> getReports() {
        return reports;
    }
}
