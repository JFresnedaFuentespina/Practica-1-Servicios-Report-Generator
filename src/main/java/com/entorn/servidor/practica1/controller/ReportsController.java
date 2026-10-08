package com.entorn.servidor.practica1.controller;

import com.entorn.servidor.practica1.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
class ReportsController {
    private ReportService reportService;

    @Autowired
    public ReportsController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/html")
    public String generarHtml() {
        return this.reportService.generateHtmlReport();
    }

    @GetMapping("/pdf")
    public String generarPdf() {
        return this.reportService.generatePdfReport();
    }

    @GetMapping("/csv")
    public String generarCsv() {
        return this.reportService.generateCsvReport();
    }

    @GetMapping("/stats")
    public String showStats() {
        return this.reportService.showStats();
    }
}
