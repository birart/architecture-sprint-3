package com.yandex.architect.device_management.clients;

import com.yandex.architect.device_management.objects.DeviceStatus;
import com.yandex.architect.device_management.objects.dto.DeviceCommandDto;
import org.springframework.stereotype.Component;

/**
 * Заглушка для обращения к сервису обнаружения устройств, который работает как прокси
 */
@Component
public class ProxyClientStub {

    public void setStatus(Integer deviceId, DeviceStatus deviceStatusDto) {}

    public void executeCommand(Integer deviceId, DeviceCommandDto deviceCommandDto) {}
}
