CREATE TABLE empresa
(
    id           SERIAL PRIMARY KEY,
    nome         VARCHAR(255) NOT NULL,
    nome_fantasia VARCHAR(255),
    email        VARCHAR(255) NOT NULL,
    cnpj         VARCHAR(14)  NOT NULL
);

CREATE TABLE categoria_produto
(
    id         SERIAL PRIMARY KEY,
    nome       VARCHAR(255) NOT NULL,
    empresa_id BIGINT       NOT NULL,
    FOREIGN KEY (empresa_id) REFERENCES empresa (id)
);

INSERT INTO empresa (nome, nome_fantasia, email, cnpj)
VALUES ('Baesso Mateus Floricultura LTDA', 'Floricultura Baesso', 'floricultura.baesso@geradornv.com.br', '50218476000171');

INSERT INTO empresa (nome, nome_fantasia, email, cnpj)
VALUES ('Dolores Pena Pizzaria LTDA', 'Pizzaria Dolores', 'pizzaria.dolores@geradornv.com.br', '14314525000106');

INSERT INTO empresa (nome, nome_fantasia, email, cnpj)
VALUES ('Silva Cunha Mercado LTDA', 'Mercado Silva', 'mercado.silva@geradornv.com.br', '23548527000150');

INSERT INTO categoria_produto (nome, empresa_id)
VALUES ('Rosa', 1);

INSERT INTO categoria_produto (nome, empresa_id)
VALUES ('Orquídeas', 1);

INSERT INTO categoria_produto (nome, empresa_id)
VALUES ('Massas', 2);

INSERT INTO categoria_produto (nome, empresa_id)
VALUES ('Bebida', 2);

INSERT INTO categoria_produto (nome, empresa_id)
VALUES ('Perecíveis', 3);


