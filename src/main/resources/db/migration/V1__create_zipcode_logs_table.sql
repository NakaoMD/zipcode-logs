CREATE TABLE zipcode_logs (
    id SERIAL PRIMARY KEY,
    cep VARCHAR(20) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    timestamp TIMESTAMP NOT NULL
);

CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- admin admin
INSERT INTO users (username, password) VALUES ('admin', '$2b$12$7P73ETagGmVxfgNMDnIM2eQKDIkdIRWyot5bbLlhf/Mdtt0v8phwq');
