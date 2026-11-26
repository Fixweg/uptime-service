CREATE TABLE check_result (
    id               BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    monitor_id       BIGINT       NOT NULL REFERENCES monitor (id) ON DELETE CASCADE,
    checked_at       TIMESTAMPTZ  NOT NULL,
    status           VARCHAR(10)  NOT NULL CHECK (status IN ('UP', 'DOWN')),
    response_time_ms INTEGER,
    status_code      INTEGER,
    error_message    VARCHAR(500)
);

CREATE INDEX idx_check_result_monitor_checked
    ON check_result (monitor_id, checked_at DESC);