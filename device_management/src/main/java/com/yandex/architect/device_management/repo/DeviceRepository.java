package com.yandex.architect.device_management.repo;

import com.yandex.architect.device_management.objects.DeviceEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface DeviceRepository extends Repository<DeviceEntity, Integer> {

    @Query("""
            SELECT id, module_id, name, type, status, serial FROM devices WHERE id = :deviceId
            """)
    DeviceEntity findById(@Param("deviceId") Integer deviceId);

    @Query("""
            UPDATE devices SET status = :deviceStatus WHERE id = :deviceId
            """)
    @Modifying
    void updateStatus(@Param("deviceId") Integer deviceId, @Param("deviceStatus") Integer deviceStatus);

    @Query("""
            INSERT INTO devices(module_id, name, type, status, serial) VALUES (:moduleId, :name, :type, :status, :serial) RETURNING id
            """)
    Integer saveDevice(@Param("moduleId") Integer moduleId, @Param("name") String name, @Param("type") String type,
                       @Param("status") String status, @Param("serial") String serial);
}
