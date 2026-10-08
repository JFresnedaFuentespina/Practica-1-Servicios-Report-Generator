package com.entorn.servidor.practica1.service;

import com.entorn.servidor.practica1.domain.*;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private ReportGenerator htmlReportGenerator;
    private ReportGenerator pdfReportGenerator;
    private ReportGenerator csvReportGenerator;

    private Watermark watermark;

    private ReportStatistics reportStatistics;

    private ReportCache cache;

    @Autowired
    public ReportService(ReportGenerator pdfReportGenerator,
                         @Qualifier("htmlReportGenerator") ReportGenerator htmlReportGenerator,
                         @Qualifier("csvReportGenerator") ReportGenerator csvReportGenerator,
                         ReportStatistics reportStatistics,
                         ReportCache cache) {
        this.pdfReportGenerator = pdfReportGenerator;
        this.htmlReportGenerator = htmlReportGenerator;
        this.csvReportGenerator = csvReportGenerator;
        this.reportStatistics = reportStatistics;
        this.cache = cache;
    }

    @PostConstruct
    public void initCache() {
        cache.initReports();
        cache.printCache();
    }

    @PreDestroy
    public void clearCache() {
        cache.clearReports();
    }

    public String generateHtmlReport() {
        String report = this.htmlReportGenerator.generarInforme();
        String id = this.htmlReportGenerator.getId();
        if (this.watermark != null) {
            report += " | " + this.watermark.getWatermark();
        }
        this.reportStatistics.addHtml();
        this.cache.addReport(id, "HTML");
        return report;
    }

    public String generatePdfReport() {
        String report = this.pdfReportGenerator.generarInforme();
        String id = this.pdfReportGenerator.getId();
        if (this.watermark != null) {
            report += " | " + this.watermark.getWatermark();
        }
        this.reportStatistics.addPdf();
        this.cache.addReport(id, "PDF");
        return report;
    }

    public String generateCsvReport() {
        String report = this.csvReportGenerator.generarInforme();
        String id = this.csvReportGenerator.getId();
        if (this.watermark != null) {
            report += " | " + this.watermark.getWatermark();
        }
        this.reportStatistics.addCsv();
        this.cache.addReport(id, "CSV");
        return report;
    }

    public String showStats() {
        cache.printCache();
        return "HTML: " + reportStatistics.getContadorHtml() +
                "\nCSV: " + reportStatistics.getContadorCsv() +
                "\nPDF: " + reportStatistics.getContadorPdf();
    }

    @Autowired(required = false)
    public void setWatermark(Watermark watermark) {
        this.watermark = watermark;
    }

    public void printCache() {
        cache.printCache();
    }

    public String getWatermak() {
        return this.watermark.getWatermark();
    }
}
