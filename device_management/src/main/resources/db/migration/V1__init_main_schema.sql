CREATE TABLE IF NOT EXISTS devices (
                         id SERIAL PRIMARY KEY,
                         module_id INTEGER NOT NULL,
                         name VARCHAR (255) NOT NULL,
                         type VARCHAR (255) NOT NULL,
                         status VARCHAR (255) NOT NULL,
                         serial VARCHAR (255) NOT NULL
);