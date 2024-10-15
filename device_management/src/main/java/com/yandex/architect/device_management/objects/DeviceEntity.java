package com.yandex.architect.device_management.objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("devices")
public class DeviceEntity {

    @Id
    private Integer id;
    @Column("module_id")
    private Integer moduleId;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private Integer status;
    @Column
    private String serial;

    public DeviceEntity() {
    }

    public DeviceEntity(Integer id, Integer moduleId, String name, String type, int status, String serial) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
        DeviceEntity that = (DeviceEntity) o;
        return id.equals(that.id) && moduleId.equals(that.moduleId) && name.equals(that.name) && type.equals(that.type)
                && status.equals(that.status) && serial.equals(that.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleId, name, type, status, serial);
    }
}
