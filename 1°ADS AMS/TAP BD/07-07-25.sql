CREATE DATABASE empresa;
USE empresa;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2)
);

CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    produto_id INT,
    data_pedido DATE,
    quantidade INT,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);

INSERT INTO clientes (nome, email) VALUES
('Nickolas', 'nickolas@gmail.com'),
('Jorge', 'jorge@gmail.com'),
('Ana', 'ana@gmail.com'),
('Ana Souza', 'ana.souza@email.com'),
('Felipe Costa', 'felipe.costa@email.com'),
('Luciana Almeida', 'luciana.almeida@email.com'),
('Rafael Gomes', 'rafael.gomes@email.com'),
('Patrícia Lima', 'patricia.lima@email.com'),
('Eduardo Santos', 'eduardo.santos@email.com'),
('Juliana Martins', 'juliana.martins@email.com');

INSERT INTO produtos (nome, descricao, preco) VALUES
('Camiseta', 'Camiseta de algodão, confortável e estilosa', 39.90),
('Tênis Esportivo', 'Tênis para corrida e atividades físicas', 199.99),
('Mochila', 'Mochila resistente para uso diário', 89.90),
('Calça Jeans', 'Calça jeans masculina, ajustada e confortável', 129.90),
('Jaqueta de Couro', 'Jaqueta de couro legítimo, estilo rocker', 299.90),
('Boné', 'Boné de aba reta, estilo street', 49.90),
('Óculos de Sol', 'Óculos de sol com proteção UV', 99.90),
('Relógio', 'Relógio de pulso com design moderno', 159.90),
('Bermuda', 'Bermuda de praia, ideal para o verão', 69.90),
('Tênis Casual', 'Tênis casual para uso no dia a dia', 159.90);

INSERT INTO pedidos (cliente_id, produto_id, data_pedido, quantidade) VALUES
(1, 2, '2025-07-07', 1), 
(2, 1, '2025-07-06', 2), 
(3, 3, '2025-07-05', 1), 
(4, 5, '2025-07-04', 1), 
(5, 4, '2025-07-03', 3), 
(6, 7, '2025-07-02', 1), 
(7, 9, '2025-07-01', 2), 
(8, 10, '2025-06-30', 1),
(9, 8, '2025-06-29', 1), 
(10, 6, '2025-06-28', 1);

-- Mostra a estrutura da tabela 'pedidos'
DESCRIBE pedidos;

-- Mostra o plano de execução da consulta sobre a tabela 'pedidos'
EXPLAIN SELECT * FROM pedidos WHERE cliente_id = 1;

-- Atualiza estatísticas da tabela 'clientes' para o otimizador
ANALYZE TABLE clientes;

-- Reorganiza e compacta a tabela 'produtos'
OPTIMIZE TABLE produtos;

-- Criação de tabela com particionamento por ano da data do pedido
CREATE TABLE pedidos_particionados (
  id INT NOT NULL,
  cliente_id INT,
  data_pedido DATE NOT NULL,
  PRIMARY KEY (id, data_pedido)
)
ENGINE = InnoDB
PARTITION BY RANGE (YEAR(data_pedido)) (
  PARTITION p2022 VALUES LESS THAN (2023),
  PARTITION p2023 VALUES LESS THAN (2024),
  PARTITION pFuturo VALUES LESS THAN MAXVALUE
);

INSERT INTO pedidos_particionados (id, cliente_id, data_pedido) VALUES
(1, 1, '2022-05-10'),
(2, 1, '2023-06-15'),
(3, 2, '2024-01-10');

-- Mostra quais partições serão utilizadas na consulta
EXPLAIN PARTITIONS
SELECT * FROM pedidos_particionados
WHERE data_pedido BETWEEN '2023-01-01' AND '2023-12-31';

-- Consulta de permissões de usuários no banco de dados MySQL
SELECT host, user, select_priv, insert_priv, update_priv, delete_priv FROM mysql.user;