package com.yandex.architect.telemetry.service;

import com.yandex.architect.telemetry.objects.TelemetryDataEntity;
import com.yandex.architect.telemetry.repo.TelemetryRepository;
import com.yandex.architect.telemetry.web.dto.TelemetryValueDto;
import com.yandex.architect.telemetry.web.dto.TelemetryValuePostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelemetryService {

    private final TelemetryRepository telemetryRepository;

    @Autowired
    public TelemetryService(TelemetryRepository telemetryRepository) {
        this.telemetryRepository = telemetryRepository;
    }

    public TelemetryValueDto getLatest(Integer deviceId) throws IllegalArgumentException {
        validateDeviceId(deviceId);
        final TelemetryDataEntity entity = telemetryRepository.getLatest(deviceId);
        if (entity == null) {
            return null;
        }

        return new TelemetryValueDto(entity.getDeviceId(), entity.getValue(), entity.getTime(), entity.getType());
    }

    public List<TelemetryValueDto> getTelemetry(Integer deviceId, LocalDateTime dateStart, LocalDateTime dateEnd,
                                                Integer page, Integer pageSize) {
        int offset = 0;
        if (page > 1) {
            offset = page * pageSize;
        }
        return telemetryRepository
                .getTelemetry(deviceId, dateStart, dateEnd, pageSize, offset)
                .stream()
                .map(entity -> new TelemetryValueDto(entity.getDeviceId(), entity.getValue(), entity.getTime(),
                        entity.getType()))
                .collect(Collectors.toList());
    }

    public void insertTelemetry(Integer deviceId, TelemetryValuePostDto telemetryValuePostDto) {
        validateDeviceId(deviceId);
        telemetryRepository.insertTelemetry(deviceId, telemetryValuePostDto.getValue(),
                telemetryValuePostDto.getType());
    }

    public void validateDeviceId(Integer deviceId) throws IllegalArgumentException {
        if (deviceId == null || deviceId < 1) {
            throw new IllegalArgumentException();
        }
    }

}
