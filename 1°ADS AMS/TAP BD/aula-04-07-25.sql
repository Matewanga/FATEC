-- (Criar a estrutura do banco de dados da loja com as tabelas: clientes, produtos, pedidos, itens_pedido.)
CREATE TABLE IF NOT EXISTS `client` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(100),
  `email` VARCHAR(100),
  `city` VARCHAR(100),
  `state` CHAR(2),
  INDEX `idx_city` (`city`)
);

CREATE TABLE IF NOT EXISTS `product` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(100),
  `description` TEXT,
  `price` DECIMAL(10,2),
  `category` VARCHAR(50),
  FULLTEXT INDEX `idx_description` (`description`)
);

CREATE TABLE IF NOT EXISTS `order` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `client_id` INT,
  `order_date` DATE,
  FOREIGN KEY (`client_id`) REFERENCES `client`(`id`),
  INDEX `idx_client` (`client_id`),
  INDEX `idx_order_date` (`order_date`)
);

CREATE TABLE IF NOT EXISTS `item_order` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `order_id` INT,
  `product_id` INT,
  `amount` INT,
  `unit_price` DECIMAL(10,2),
  FOREIGN KEY (`order_id`) REFERENCES `order`(`id`),
  FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
  
  INDEX `idx_order` (`order_id`),
  INDEX `idx_product` (`product_id`)
);

-- (Inserir dados fictícios.)

INSERT INTO `client` (`name`, `email`, `city`, `state`) VALUES
("Nickolas", "nickolas@gmail.com", "São Paulo", "SP"),
("Jorge", "jorge@gmail.com", "São José dos Campos", "SP"),
("Artur", "artur@gmail.com", "Florianópolis", "SC"),
("Beatriz", "beatriz@gmail.com", "Curitiba", "PR"),
("Mariana", "mariana@gmail.com", "Rio de Janeiro", "RJ"),
("Carlos", "carlos@gmail.com", "Belo Horizonte", "MG"),
("Fernanda", "fernanda@gmail.com", "Porto Alegre", "RS"),
("Lucas", "lucas@gmail.com", "Campinas", "SP"),
("Patrícia", "patricia@gmail.com", "Salvador", "BA"),
("Roberto", "roberto@gmail.com", "Recife", "PE");

INSERT INTO `product` (`name`, `description`, `price`, `category`) VALUES
("Notebook", "Notebook Intel i7", 2699.99, "tecnologia"),
("Smartphone", "Smartphone Android 128GB", 1499.90, "tecnologia"),
("Cadeira Gamer", "Cadeira ergonômica com apoio lombar", 899.00, "móveis"),
("Fone Bluetooth", "Fone de ouvido sem fio com cancelamento de ruído", 299.90, "tecnologia"),
("Smartwatch", "Relógio inteligente com monitor de batimentos", 499.99, "tecnologia"),
("Geladeira", "Geladeira duplex 400L", 2399.00, "eletrodomésticos"),
("Teclado", "Teclado comum", 199.00, "eletrônicos"),
("Teclado Mecânico", "Teclado gamer com iluminação RGB", 349.90, "tecnologia"),
("Mesa Escritório", "Mesa de escritório com gavetas", 599.00, "móveis"),
("Micro-ondas", "Micro-ondas 30L com grill", 699.99, "eletrodomésticos");

INSERT INTO `order` (`client_id`, `order_date`) VALUES
(1, '2022-01-12'),
(2, '2022-03-16'),
(3, '2023-05-22'),
(4, '2023-07-02'),
(5, '2023-08-26'),
(6, '2024-02-15'),
(7, '2024-04-25'),
(8, '2024-07-01'),
(9, '2024-07-01'),
(10, '2024-07-02');

INSERT INTO `item_order` (`order_id`, `product_id`, `amount`, `unit_price`) VALUES
(1, 1, 1, 2699.99),
(1, 4, 2, 299.90),
(2, 2, 1, 1499.90),
(3, 3, 1, 899.00),
(3, 8, 1, 349.90),
(4, 5, 1, 499.99),
(5, 6, 1, 2399.00),
(5, 10, 1, 699.99),
(6, 7, 1, 2199.00),
(7, 2, 1, 1499.90),
(7, 9, 1, 599.00),
(8, 4, 1, 299.90),
(9, 8, 2, 349.90),
(10, 3, 1, 899.00),
(10, 6, 1, 2399.00);

-- (Realizar consultas de exemplo, como)

-- Buscar todos os pedidos feitos por um cliente específico. 
-- Os índices relevantes são:
-- - idx_client em order(client_id), utilizado no JOIN com client.
-- - idx_order em item_order(order_id), para associar pedidos aos itens.
-- - idx_product em item_order(product_id), para pegar os produtos comprados.
SELECT `client`.`name` as `nome_client`, `product`.* FROM `item_order`
INNER JOIN `order` ON `item_order`.`order_id` = `order`.`id`
INNER JOIN `product` on `item_order`.`product_id` = `product`.`id`
INNER JOIN `client` on `order`.client_id = `client`.`id`
WHERE `client`.`name` = "Nickolas";

-- Buscar produtos por categoria usando FULLTEXT.
-- O índice FULLTEXT idx_description é usado aqui.
-- Ele permite buscas mais performáticas que LIKE para colunas de texto.
-- O FULLTEXT é ativado com MATCH(description) AGAINST('teclado').
SELECT * FROM `product`
WHERE MATCH(`description`) AGAINST ("teclado");

-- Gerar relatório de pedidos por faixa de data
-- O índice idx_order_date em order(order_date) é utilizado para melhorar a busca por datas.
-- Também há JOIN com client usando o índice idx_client.
SELECT `order`.`id`, `client`.`name`, `order`.`order_date` FROM `order`
INNER JOIN `client` ON `order`.`client_id` = `client`.`id`
WHERE `order_date` BETWEEN '2022-01-05' AND '2022-12-31'
ORDER BY `order_date`;

-- Utilizar os comandos:
-- EXPLAIN ou EXPLAIN ANALYZE para verificar o uso de índices.
-- Usa o índice idx_city para filtrar por cidade.
EXPLAIN SELECT * FROM `client` WHERE `city` = "São Paulo";

-- Usa o índice FULLTEXT idx_description para busca textual.
EXPLAIN SELECT * FROM `product` WHERE MATCH(`description`) AGAINST("teclado");

-- Usa idx_client para filtrar pedidos por ID de cliente.
EXPLAIN SELECT * FROM `order` WHERE `client_id` = 3;

-- Usa idx_order_date para filtrar pedidos por intervalo de datas.
EXPLAIN SELECT * FROM `order` WHERE `order_date` BETWEEN '2025-01-01' AND '2025-12-12';

-- Usa idx_order para localizar itens de um pedido específico.
EXPLAIN SELECT * FROM `item_order` WHERE `order_id` = 2;

-- Usa idx_product para localizar itens com determinado produto.
EXPLAIN SELECT * FROM `item_order` WHERE `product_id` = 7;

-- ANALYZE TABLE e OPTIMIZE TABLE para manutenção
ANALYZE TABLE `client`;
OPTIMIZE TABLE `product`;

-- Criar uma nova tabela de pedidos particionados por ano (ex: 2022, 2023, 2024) e realizar uma consulta usando EXPLAIN PARTITIONS.
CREATE TABLE `parted_orders` (
  `id` INT NOT NULL,
  `client_id` INT,
  `order_date` DATE NOT NULL,
  PRIMARY KEY (`id`, `order_date`)
)
PARTITION BY RANGE (YEAR(`order_date`)) (
  PARTITION `order2022` VALUES LESS THAN (2023),
  PARTITION `order2023` VALUES LESS THAN (2024),
  PARTITION `orderFuture` VALUES LESS THAN MAXVALUE
);

EXPLAIN PARTITIONS SELECT * FROM `parted_orders` WHERE `order_date` BETWEEN '2023-01-01' AND '2023-12-31';