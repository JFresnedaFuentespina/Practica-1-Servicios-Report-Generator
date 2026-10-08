package com.entorn.servidor.practica1.service;

import com.entorn.servidor.practica1.domain.PdfReportGenerator;
import com.entorn.servidor.practica1.domain.ReportGenerator;
import com.entorn.servidor.practica1.domain.ReportStatistics;
import com.entorn.servidor.practica1.domain.Watermark;
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

    @Autowired
    public ReportService(ReportGenerator pdfReportGenerator,
                         @Qualifier("htmlReportGenerator") ReportGenerator htmlReportGenerator,
                         @Qualifier("csvReportGenerator") ReportGenerator csvReportGenerator,
                         ReportStatistics reportStatistics) {
        this.pdfReportGenerator = pdfReportGenerator;
        this.htmlReportGenerator = htmlReportGenerator;
        this.csvReportGenerator = csvReportGenerator;
        this.reportStatistics = reportStatistics;
    }

    public String generateHtmlReport() {
        String report = this.htmlReportGenerator.generarInforme();
        if (this.watermark != null) {
            report += " | " + this.watermark.getWatermark();
        }
        this.reportStatistics.addHtml();
        return report;
    }

    public String generatePdfReport() {
        String report = this.pdfReportGenerator.generarInforme();
        if (this.watermark != null) {
            report += " | " + this.watermark.getWatermark();
        }
        this.reportStatistics.addPdf();
        return report;
    }

    public String generateCsvReport() {
        String report = this.csvReportGenerator.generarInforme();
        if (this.watermark != null) {
            report += " | " + this.watermark.getWatermark();
        }
        this.reportStatistics.addCsv();
        return report;
    }

    public String showStats() {
        return "HTML: " + reportStatistics.getContadorHtml() +
                "\nCSV: " + reportStatistics.getContadorCsv() +
                "\nPDF: " + reportStatistics.getContadorPdf();
    }

    @Autowired(required = false)
    public void setWatermark(Watermark watermark) {
        this.watermark = watermark;
    }

    public String getWatermak() {
        return this.watermark.getWatermark();
    }
}
