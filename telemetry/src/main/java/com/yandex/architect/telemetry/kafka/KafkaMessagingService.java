package com.yandex.architect.telemetry.kafka;

import com.yandex.architect.telemetry.kafka.event.TelemetryEvent;
import com.yandex.architect.telemetry.repo.TelemetryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagingService {

    public static final String topic = "telemetry";
    public static final String groupId = "telemetry";

    private final TelemetryRepository telemetryRepository;

    @Autowired
    public KafkaMessagingService(TelemetryRepository telemetryRepository) {
        this.telemetryRepository = telemetryRepository;
    }

    @KafkaListener(topics = topic, groupId = groupId, properties = {
            "spring.json.value.default.type=com.yandex.architect.telemetry.kafka.event.TelemetryEvent"})
    public void registerDevice(TelemetryEvent telemetryEvent) {
        final Integer deviceId = telemetryEvent.getDeviceId();
        final Float value = telemetryEvent.getValue();
        final String type = telemetryEvent.getType();
        telemetryRepository.insertTelemetry(deviceId, value, type);
    }

}
