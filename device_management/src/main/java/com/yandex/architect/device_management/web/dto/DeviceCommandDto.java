package com.yandex.architect.device_management.web.dto;

import java.util.Objects;

public class DeviceCommandDto {

    private Integer deviceId;
    private String command;
    private String type;
    private Double value;

    public DeviceCommandDto(Integer deviceId, String command) {
        this.deviceId = deviceId;
        this.command = command;
    }

    public DeviceCommandDto(Integer deviceId, String command, String type, Double value) {
        this.deviceId = deviceId;
        this.command = command;
        this.type = type;
        this.value = value;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeviceCommandDto that = (DeviceCommandDto) o;
        return deviceId.equals(that.deviceId) && command.equals(that.command) && Objects.equals(type, that.type)
                && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, command, type, value);
    }
}
