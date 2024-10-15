package com.yandex.architect.telemetry.web;

import com.yandex.architect.telemetry.service.TelemetryService;
import com.yandex.architect.telemetry.web.dto.TelemetryValueDto;
import com.yandex.architect.telemetry.web.dto.TelemetryValuePostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/devices")
public class TelemetryManagementController {

    private final TelemetryService telemetryService;

    @Autowired
    public TelemetryManagementController(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @GetMapping("/{device_id}/telemetry/latest")
    public ResponseEntity<TelemetryValueDto> getLatest(@PathVariable("device_id") Integer deviceId) {
        try {
            final TelemetryValueDto latest = telemetryService.getLatest(deviceId);
            if (latest == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(latest);
        } catch (IllegalArgumentException illegalArgumentException) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{device_id}/telemetry")
    public ResponseEntity<List<TelemetryValueDto>> getTelemetry(@PathVariable("device_id") Integer deviceId,
                                                             @RequestParam("date_start") LocalDateTime dateStart,
                                                             @RequestParam("date_end") LocalDateTime dateEnd,
                                                             @RequestParam("page") Integer page,
                                                             @RequestParam("page_size") Integer pageSize) {
        try {
            final List<TelemetryValueDto> telemetry = telemetryService.getTelemetry(deviceId, dateStart, dateEnd, page, pageSize);
            if (telemetry == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(telemetry);
        } catch (IllegalArgumentException illegalArgumentException) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/{device_id}/telemetry")
    public ResponseEntity<Void> insertTelemetry(@PathVariable("device_id") Integer deviceId, @RequestBody
            TelemetryValuePostDto telemetryValuePostDto) {
        try {
            telemetryService.insertTelemetry(deviceId, telemetryValuePostDto);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException illegalArgumentException) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
