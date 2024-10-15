package com.yandex.architect.telemetry.web.dto;

public class TelemetryValuePostDto {

    private Float value;
    private String type;

    public TelemetryValuePostDto() {
    }

    public TelemetryValuePostDto(Float value, String type) {
        this.value = value;
        this.type = type;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
