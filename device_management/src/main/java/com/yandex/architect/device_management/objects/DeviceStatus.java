package com.yandex.architect.device_management.objects;

import java.util.Arrays;

public enum DeviceStatus {
    OFF(0, "off"),
    ON(1, "on");

    private final int statusCode;
    private final String statusLabel;

    DeviceStatus(int statusCode, String statusLabel) {
        this.statusCode = statusCode;
        this.statusLabel = statusLabel;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public static DeviceStatus findByLabel(String label) {
        return Arrays
                .stream(values())
                .filter(deviceStatus -> deviceStatus.statusLabel.equals(label))
                .findFirst()
                .orElse(null);
    }

    public static DeviceStatus findByCode(int statusCode) {
        return Arrays
                .stream(values())
                .filter(deviceStatus -> deviceStatus.statusCode == statusCode)
                .findFirst()
                .orElse(null);
    }
}
