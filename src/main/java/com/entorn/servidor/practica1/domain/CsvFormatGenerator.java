package com.entorn.servidor.practica1.domain;

import com.entorn.servidor.practica1.config.ReportConfig;
import org.apache.commons.csv.CSVFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CsvFormatGenerator {
    private final CSVFormat csvFormat;

    @Autowired
    public CsvFormatGenerator(CSVFormat csvFormat) {
        this.csvFormat = csvFormat;
    }

    public CSVFormat getFormat() {
        return csvFormat;
    }
}
