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

    @Autowired
    public CsvReportGenerator(ReportJobFactory reportJob,
                              CsvFormatGenerator csvFormatGenerator) {
        this.reportJobFactory = reportJob;
        this.csvFormatGenerator = csvFormatGenerator;
    }


    @Override
    public String generarInforme() {
        String id = this.reportJobFactory.createReportJob().getId();
        CSVFormat format = this.csvFormatGenerator.getFormat();
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
        return this.reportJobFactory.createReportJob().getId();
    }
}
