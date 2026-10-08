package com.entorn.servidor.practica1.domain;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;

@Component
public class CsvReportGenerator implements ReportGenerator {
    private final ReportJobFactory reportJobFactory;
    private final CsvFormatGenerator csvFormatGenerator;
    private ReportJob reportJob;

    @Autowired
    public CsvReportGenerator(ReportJobFactory reportJobFactory,
                              CsvFormatGenerator csvFormatGenerator) {
        this.reportJobFactory = reportJobFactory;
        this.csvFormatGenerator = csvFormatGenerator;
    }


    @Override
    public String generarInforme() {
        reportJob = reportJobFactory.createReportJob();
        String id = reportJob.getId();
        CSVFormat format = csvFormatGenerator.getFormat();
        String contenido = "Informe " + id;
        StringWriter writer = new StringWriter();

        try (CSVPrinter printer = new CSVPrinter(writer, format)) {
            printer.printRecord(id, contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    @Override
    public String getId() {
        return this.reportJob.getId();
    }
}
