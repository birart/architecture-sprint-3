CREATE TABLE IF NOT EXISTS telemetry
(
    id UInt32,
    device_id UInt32,
    value Float32,
    time DateTime,
    type String,
    PRIMARY KEY (id)
) ENGINE = MergeTree
ORDER BY (id, time);
