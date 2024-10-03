package com.yandex.architect.device_management.web.dto;

import java.util.Objects;

public class DeviceDto {

    private Integer id;
    private Integer moduleId;
    private String name;
    private String type;
    private String status;
    private String serial;

    public DeviceDto() {

    }

    public DeviceDto(Integer id, Integer moduleId, String name, String type, String status, String serial) {
        this.id = id;
        this.moduleId = moduleId;
        this.name = name;
        this.type = type;
        this.status = status;
        this.serial = serial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeviceDto deviceDto = (DeviceDto) o;
        return id.equals(deviceDto.id) && moduleId.equals(deviceDto.moduleId) && name.equals(deviceDto.name)
                && type.equals(deviceDto.type) && status.equals(deviceDto.status) && serial.equals(deviceDto.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleId, name, type, status, serial);
    }
}
