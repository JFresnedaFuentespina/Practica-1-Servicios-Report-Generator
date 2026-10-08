package com.entorn.servidor.practica1.domain;

import org.springframework.stereotype.Component;

@Component
public class Watermark {
    public String getWatermark() {
        return "Marca de agua";
    }
}
