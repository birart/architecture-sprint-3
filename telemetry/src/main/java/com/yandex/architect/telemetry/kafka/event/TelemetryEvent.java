package com.yandex.architect.telemetry.kafka.event;

public class TelemetryEvent {
    private Integer deviceId;
    private Float value;
    private String type;

    public TelemetryEvent() {
    }

    public TelemetryEvent(Integer deviceId, Float value, String type) {
        this.deviceId = deviceId;
        this.value = value;
        this.type = type;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
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
