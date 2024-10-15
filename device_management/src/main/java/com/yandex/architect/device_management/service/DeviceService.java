package com.yandex.architect.device_management.service;

import com.yandex.architect.device_management.clients.ProxyClientStub;
import com.yandex.architect.device_management.objects.DeviceEntity;
import com.yandex.architect.device_management.objects.DeviceStatus;
import com.yandex.architect.device_management.repo.DeviceRepository;
import com.yandex.architect.device_management.objects.dto.DeviceCommandDto;
import com.yandex.architect.device_management.objects.dto.DeviceDto;
import com.yandex.architect.device_management.objects.dto.DeviceStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final ProxyClientStub proxyClientStub;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, ProxyClientStub proxyClientStub) {
        this.deviceRepository = deviceRepository;
        this.proxyClientStub = proxyClientStub;
    }

    public DeviceDto getDevice(Integer deviceId) throws IllegalArgumentException {
        validateDeviceId(deviceId);
        final DeviceEntity record = deviceRepository.findById(deviceId);
        if (record == null) {
            return null;
        }

        final int statusCode = record.getStatus();
        final DeviceStatus deviceStatus = DeviceStatus.findByCode(statusCode);

        return new DeviceDto(record.getId(), record.getModuleId(), record.getName(), record.getType(), deviceStatus.getStatusLabel(), record.getSerial());
    }

    @Async
    public void updateStatus(Integer deviceId, DeviceStatusDto deviceStatus) throws IllegalArgumentException {
        validateDeviceId(deviceId);
        if (deviceStatus == null) {
            throw new IllegalArgumentException();
        }
        final String receivedStatus = deviceStatus.getStatus();
        final DeviceStatus status = DeviceStatus.findByLabel(receivedStatus);
        if (status == null) {
            throw new IllegalArgumentException();
        }

        // set status for device
        proxyClientStub.setStatus(deviceId, status);

        deviceRepository.updateStatus(deviceId, status.getStatusCode());
    }

    @Async
    public void executeCommand(Integer deviceId, DeviceCommandDto deviceCommandDto) throws IllegalArgumentException {
        validateDeviceId(deviceId);
        if (deviceCommandDto == null) {
            throw new IllegalArgumentException();
        }

        // call command for device through proxy
        proxyClientStub.executeCommand(deviceId, deviceCommandDto);
    }

    public void validateDeviceId(Integer deviceId) throws IllegalArgumentException {
        if (deviceId == null || deviceId < 1) {
            throw new IllegalArgumentException();
        }
    }
}
