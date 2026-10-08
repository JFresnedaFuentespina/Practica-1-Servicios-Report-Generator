package com.entorn.servidor.practica1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportStatistics {
    private int contadorHtml;
    private int contadorPdf;
    private int contadorCsv;

    public void addHtml() {
        this.contadorHtml++;
    }

    public void addPdf() {
        this.contadorPdf++;
    }

    public void addCsv() {
        this.contadorCsv++;
    }

    public int getContadorHtml() {
        return contadorHtml;
    }

    public int getContadorPdf() {
        return contadorPdf;
    }

    public int getContadorCsv() {
        return contadorCsv;
    }
}
