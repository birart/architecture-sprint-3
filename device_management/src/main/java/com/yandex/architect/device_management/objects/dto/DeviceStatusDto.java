package com.yandex.architect.device_management.objects.dto;

public class DeviceStatusDto {
    private String status;

    public DeviceStatusDto() {
    }

    public DeviceStatusDto(String status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
