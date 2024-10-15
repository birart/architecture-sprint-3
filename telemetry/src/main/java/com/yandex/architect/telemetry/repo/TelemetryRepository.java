package com.yandex.architect.telemetry.repo;

import com.yandex.architect.telemetry.objects.TelemetryDataEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TelemetryRepository extends Repository<TelemetryDataEntity, Integer> {

    @Query("""
            SELECT * FROM telemetry WHERE device_id = :deviceId LIMIT 1
            """)
    TelemetryDataEntity getLatest(@Param("deviceId") Integer deviceId);


    @Query("""
            SELECT * FROM telemetry WHERE device_id = :deviceId AND time > :dateStart AND time < :dateEnd ORDER BY time DESC LIMIT :limit OFFSET :offset
            """)
    List<TelemetryDataEntity> getTelemetry(@Param("deviceId") Integer deviceId,
                                           @Param("dateStart") LocalDateTime dateStart,
                                           @Param("dateEnd") LocalDateTime dateEnd,
                                           @Param("limit") Integer limit,
                                           @Param("offset") Integer offset);

    @Query("""
        INSERT INTO telemetry(device_id, value, time, type) VALUES (:deviceId, :value, now(), :type)
    """)
    @Modifying
    void insertTelemetry(@Param("deviceId") Integer deviceId, @Param("value") Float value, @Param("type") String type);
}
