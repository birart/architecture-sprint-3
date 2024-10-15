package com.yandex.architect.device_management.kafka;

import com.yandex.architect.device_management.kafka.event.DeviceRegisterEvent;
import com.yandex.architect.device_management.objects.dto.DeviceDto;
import com.yandex.architect.device_management.repo.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagingService {

    public static final String topic = "device_register";
    public static final String groupId = "device_register";

    private final DeviceRepository deviceRepository;

    @Autowired
    public KafkaMessagingService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @KafkaListener(topics = topic, groupId = groupId, properties = {
            "spring.json.value.default.type=com.yandex.architect.device_management.kafka.event.DeviceRegisterEvent"})
    public DeviceDto registerDevice(DeviceRegisterEvent deviceRegisterEvent) {
        final Integer moduleId = deviceRegisterEvent.getModuleId();
        final String name = deviceRegisterEvent.getName();
        final String type = deviceRegisterEvent.getType();
        final String status = deviceRegisterEvent.getStatus();
        final String serial = deviceRegisterEvent.getSerial();
        Integer id = deviceRepository.saveDevice(moduleId, name, type, status, serial);
        return new DeviceDto(id, moduleId, name, type, status, serial);
    }

}
