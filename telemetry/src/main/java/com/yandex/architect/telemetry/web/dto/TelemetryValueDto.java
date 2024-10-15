package com.yandex.architect.telemetry.web.dto;

import java.time.LocalDateTime;

public class TelemetryValueDto {

    private Integer deviceId;
    private Float value;
    private LocalDateTime time;
    private String type;

    public TelemetryValueDto() {

    }

    public TelemetryValueDto(Integer deviceId, Float value, LocalDateTime time, String type) {
        this.deviceId = deviceId;
        this.value = value;
        this.time = time;
        this.type = type;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
