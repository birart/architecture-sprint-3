package com.yandex.architect.telemetry.objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("telemetry")
public class TelemetryDataEntity {

    @Id
    private Integer id;
    @Column("device_id")
    private Integer deviceId;
    @Column("value")
    private Float value;
    @Column("time")
    private LocalDateTime time;
    @Column("type")
    private String type;

    public TelemetryDataEntity() {

    }

    public TelemetryDataEntity(Integer id, Integer deviceId, Float value, LocalDateTime time, String type) {
        this.id = id;
        this.deviceId = deviceId;
        this.value = value;
        this.time = time;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
