CREATE TABLE zipcode_logs (
    id SERIAL PRIMARY KEY,
    cep VARCHAR(20) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    timestamp TIMESTAMP NOT NULL
);
