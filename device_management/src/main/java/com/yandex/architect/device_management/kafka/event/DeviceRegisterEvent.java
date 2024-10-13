package com.yandex.architect.device_management.kafka.event;

public class DeviceRegisterEvent {

    private Integer moduleId;
    private String name;
    private String type;
    private String status;
    private String serial;

    public DeviceRegisterEvent() {
    }

    public DeviceRegisterEvent(Integer moduleId, String name, String type, String status, String serial) {
        this.moduleId = moduleId;
        this.name = name;
        this.type = type;
        this.status = status;
        this.serial = serial;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
