CREATE TABLE categoria
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE livro
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo       VARCHAR(255) NOT NULL,
    autor        VARCHAR(255) NOT NULL,
    categoria_id BIGINT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

INSERT INTO categoria (nome) VALUES ('Fantasia');
INSERT INTO categoria (nome) VALUES ('Tecnologia');
