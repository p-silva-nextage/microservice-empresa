CREATE TABLE empresa
(
    id            SERIAL PRIMARY KEY,
    nome          VARCHAR(255) NOT NULL,
    nome_fantasia VARCHAR(255),
    email         VARCHAR(255) NOT NULL,
    cnpj          VARCHAR(14)  NOT NULL
);

CREATE TABLE cliente
(
    id              SERIAL PRIMARY KEY,
    nome            VARCHAR(255) NOT NULL,
    cpf_cnpj        VARCHAR(20),
    tipo_pessoa     VARCHAR(15),
    email           VARCHAR(255),
    numero_telefone VARCHAR(15),
    empresa_id      BIGINT       NOT NULL,
    FOREIGN KEY (empresa_id) REFERENCES empresa (id)
);

INSERT INTO empresa (nome, nome_fantasia, email, cnpj)
VALUES ('Baesso Mateus Floricultura LTDA', 'Floricultura Baesso', 'floricultura.baesso@geradornv.com.br',
        '50218476000171');

INSERT INTO empresa (nome, nome_fantasia, email, cnpj)
VALUES ('Dolores Pena Pizzaria LTDA', 'Pizzaria Dolores', 'pizzaria.dolores@geradornv.com.br', '14314525000106');

INSERT INTO empresa (nome, nome_fantasia, email, cnpj)
VALUES ('Silva Cunha Mercado LTDA', 'Mercado Silva', 'mercado.silva@geradornv.com.br', '23548527000150');

INSERT INTO cliente (nome, cpf_cnpj, tipo_pessoa, email, numero_telefone, empresa_id)
VALUES ('João da Silva', '123.456.789-00', 'PESSOA_FISICA', 'joao.silva@example.com', '(11) 1234-5678', 1);

INSERT INTO cliente (nome, cpf_cnpj, tipo_pessoa, email, numero_telefone, empresa_id)
VALUES ('Maria Souza', '98.765.432/0001-21', 'PESSOA_JURIDICA', 'maria.souza@example.com', '(21) 99876-5432', 2);

INSERT INTO cliente (nome, cpf_cnpj, tipo_pessoa, email, numero_telefone, empresa_id)
VALUES ('Carlos Ferreira', '111.222.333-44', 'PESSOA_FISICA', 'carlos.ferreira@example.com', '(31) 1111-2222', 1);

INSERT INTO cliente (nome, cpf_cnpj, tipo_pessoa, email, numero_telefone, empresa_id)
VALUES ('Ana Oliveira', '99.888.777/0001-23', 'PESSOA_JURIDICA', 'ana.oliveira@example.com', '(41) 9999-8888', 3);

INSERT INTO cliente (nome, cpf_cnpj, tipo_pessoa, email, numero_telefone, empresa_id)
VALUES ('Pedro Santos', '555.666.777-88', 'PESSOA_FISICA', 'pedro.santos@example.com', '(51) 5555-6666', 2);



