package com.yandex.architect.device_management.web;

import com.yandex.architect.device_management.service.DeviceService;
import com.yandex.architect.device_management.web.dto.DeviceCommandDto;
import com.yandex.architect.device_management.web.dto.DeviceDto;
import com.yandex.architect.device_management.web.dto.DeviceStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devices")
public class DeviceManagementController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceManagementController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/{device_id}")
    public ResponseEntity<DeviceDto> getDevice(@PathVariable("device_id") Integer deviceId) {
        try {
            final DeviceDto deviceDto = deviceService.getDevice(deviceId);
            if (deviceDto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(deviceDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{device_id}/status")
    public ResponseEntity<Void> setStatus(@PathVariable("device_id") Integer deviceId,
                                          @RequestBody DeviceStatusDto deviceStatusDto) {
        try {
            final DeviceDto deviceDto = deviceService.getDevice(deviceId);
            if (deviceDto == null) {
                return ResponseEntity.notFound().build();
            }

            deviceService.updateStatus(deviceId, deviceStatusDto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{device_id}/commands")
    public ResponseEntity<Void> commands(@PathVariable("device_id") Integer deviceId,
                                         @RequestBody DeviceCommandDto deviceCommandDto) {
        try {
            final DeviceDto deviceDto = deviceService.getDevice(deviceId);
            if (deviceDto == null) {
                return ResponseEntity.notFound().build();
            }

            deviceService.executeCommand(deviceId, deviceCommandDto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
