/*
 create procedure nome_procedure(params)
 BEGIN
 -- corpo da procedure
 END;
 
 call nome_procedure();
 
 drop procedure if exists nome_procedure;
 */

DROP DATABASE IF EXISTS aula;

CREATE DATABASE aula;
USE aula;

-- Tabela Autores
CREATE TABLE Autores (
    AutorID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL,
    Nacionalidade VARCHAR(50)
);

-- Tabela Livros
CREATE TABLE Livros (
    LivroID INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(150) NOT NULL,
    AnoPublicacao INT,
    Preco DECIMAL(8, 2),
    AutorID INT,
    FOREIGN KEY (AutorID) REFERENCES Autores(AutorID)
);

-- Tabela Vendas
CREATE TABLE Vendas (
    VendaID INT PRIMARY KEY AUTO_INCREMENT,
    LivroID INT,
    DataVenda DATE,
    Quantidade INT,
    FOREIGN KEY (LivroID) REFERENCES Livros(LivroID)
);

-- Autores
INSERT INTO
    Autores (Nome, Nacionalidade)
VALUES
    ('J.K. Rowling', 'Britânica'),
    ('George R.R. Martin', 'Americano'),
    ('Machado de Assis', 'Brasileiro'),
    ('Stephen King', 'Americano'),
    ('Agatha Christie', 'Britânica'),
    ('Paulo Coelho', 'Brasileiro'),
    ('J. R. R. Tolkien', 'Britânico'),
    ('Dan Brown', 'Americano'),
    ('Clarice Lispector', 'Brasileira'),
    ('Neil Gaiman', 'Britânico'),
    ('Isabel Allende', 'Chilena'),
    ('Haruki Murakami', 'Japonês'),
    ('Cecelia Ahern', 'Irlandesa'),
    ('Suzanne Collins', 'Americana'),
    ('Rick Riordan', 'Americano');

-- Livros
INSERT INTO
    Livros (Titulo, AnoPublicacao, Preco, AutorID)
VALUES
    (
        'Harry Potter e a Pedra Filosofal',
        1997,
        59.90,
        1
    ),
    (
        'Harry Potter e a Câmara Secreta',
        1998,
        62.50,
        1
    ),
    ('A Game of Thrones', 1996, 70.00, 2),
    ('Dom Casmurro', 1899, 29.99, 3),
    ('It', 1986, 45.00, 4),
    (
        'Assassinato no Expresso Oriente',
        1934,
        39.90,
        5
    ),
    ('O Alquimista', 1988, 31.50, 6),
    ('O Senhor dos Anéis', 1954, 85.00, 7),
    ('O Código Da Vinci', 2003, 54.90, 8),
    ('A Hora da Estrela', 1977, 27.00, 9),
    ('Deuses Americanos', 2001, 42.00, 10),
    ('A Casa dos Espíritos', 1982, 47.80, 11),
    ('Kafka à Beira-Mar', 2002, 53.50, 12),
    ('P.S. I Love You', 2004, 37.00, 13),
    ('Jogos Vorazes', 2008, 46.00, 14);

-- Vendas
INSERT INTO
    Vendas (LivroID, DataVenda, Quantidade)
VALUES
    (1, '2025-05-01', 3),
    (2, '2025-05-03', 2),
    (3, '2025-05-02', 1),
    (4, '2025-05-01', 4),
    (5, '2025-05-04', 2),
    (6, '2025-05-04', 5),
    (7, '2025-05-05', 2),
    (8, '2025-05-06', 3),
    (9, '2025-05-07', 2),
    (10, '2025-05-08', 3),
    (11, '2025-05-09', 1),
    (12, '2025-05-10', 4),
    (13, '2025-05-11', 2),
    (14, '2025-05-11', 5),
    (15, '2025-05-12', 3);

-- Create a procedure to search for a product by ID
DELIMITER //
CREATE PROCEDURE buscar_produto_id(IN prod_id INT)
BEGIN
    SELECT * FROM Livros WHERE LivroID = prod_id;
END // 

-- Create a procedure to create a new sale
DELIMITER //
CREATE PROCEDURE nova_venda(IN livroId INT, IN dataVenda DATE, IN Quantidade INT)
BEGIN
    INSERT INTO Vendas(LivroID, DataVenda, Quantidade)
    VALUES (livroId, dataVenda, Quantidade);
END //

-- Create a procedure to view all the specific book sales 
DELIMITER //
CREATE PROCEDURE total_vendas_livro(IN pLivroId INT, OUT total INT)
BEGIN
    SELECT sum(Quantidade)
    INTO total
    FROM Vendas
    WHERE LivroID = pLivroId;
END //


-- Call the procedure with id 1
CALL buscar_produto_id(1);

-- Call the procedure to create a new sale
CALL nova_venda(1, '2025-05-13', 2);

-- Confirm the procedure execution
SELECT * FROM Vendas WHERE DataVenda = "2025-05-13";

-- Call the procedure with id book one
CALL total_vendas_livro(1, @total); -- @total is a variable
SELECT @total; -- Show the @total variable

-- Show all the procedures
-- SHOW PROCEDURE STATUS WHERE Db = "aula";


-- DATA DICTIONARY
SELECT COLUMN_NAME, DATA_TYPE, COLUMN_TYPE, IS_NULLABLE, COLUMN_DEFAULT
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'aula' AND TABLE_NAME = 'Livros';
