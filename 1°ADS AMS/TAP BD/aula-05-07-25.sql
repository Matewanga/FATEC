-- PRATICA COM USUARIOS
-- Criar um novo usuário com acesso local
CREATE USER 'nickolas'@'localhost' IDENTIFIED BY 'Senha@123';

-- Criar um usuário com acesso remoto
CREATE USER 'nickolas_remoto'@'%' IDENTIFIED BY 'Senha@123';

-- Alterar a senha do usuário
ALTER USER 'nickolas'@'localhost' IDENTIFIED BY 'NovaSenha@2025';

-- Exigir conexão segura (SSL)
ALTER USER 'nickolas_remoto'@'%' REQUIRE SSL;

-- Definir limites de uso
ALTER USER 'nickolas'@'localhost' 
WITH MAX_QUERIES_PER_HOUR 1000
     MAX_CONNECTIONS_PER_HOUR 100;

-- Expirar a senha após 60 dias
ALTER USER 'nickolas'@'localhost' PASSWORD EXPIRE INTERVAL 60 DAY;

-- Bloquear e desbloquear o usuário
ALTER USER 'nickolas'@'localhost' ACCOUNT LOCK;
ALTER USER 'nickolas'@'localhost' ACCOUNT UNLOCK;


-- Renomear o usuário local
RENAME USER 'nickolas'@'localhost' TO 'nickolas_local'@'localhost';

-- Renomear e alterar o host de acesso
RENAME USER 'nickolas_local'@'localhost' TO 'nickolas_local'@'%';

-- Excluir um usuário local
DROP USER 'nickolas_local'@'%';

-- Excluir usuário com acesso remoto
DROP USER 'nickolas_remoto'@'%';

-- Excluir múltiplos usuários
-- DROP USER 'estagiario'@'localhost', 'visitante'@'192.168.1.%';

-- Forma segura
DROP USER IF EXISTS 'vinicius'@'localhost';

-- Listar usuários
SELECT user, host FROM mysql.user;

-- PRATICA PRIVILEGIOS
-- Recriando usuário nickolas
CREATE USER 'nickolas'@'localhost';

-- Ver detalhes de configuração
SHOW CREATE USER 'nickolas'@'localhost';

-- Garantindo permissão para uma tabela
GRANT SELECT, INSERT on fatec.aula TO 'nickolas'@'localhost';

-- Verificar os privilégios de um usuário
SHOW GRANTS FOR 'nickolas'@'localhost';

-- Revogar um privilégio
REVOKE INSERT ON fatec.aula FROM 'nickolas'@'localhost';

-- Conceder todos os privilégios em um banco de dados
GRANT ALL PRIVILEGES ON fatec.* TO 'nickolas'@'localhost';

-- Conceder privilégio com opção de repasse (GRANT OPTION), ou seja, ele pode conceder seus próprios privilégios
GRANT ALL PRIVILEGES ON fatec.* TO 'nickolas'@'localhost' WITH GRANT OPTION;

-- Revogar todos os privilégios
REVOKE ALL PRIVILEGES ON fatec.* FROM 'nickolas'@'localhost';

-- Remover usuário
DROP USER 'nickolas'@'localhost';

-- EXERCICIO
CREATE DATABASE loja_do_jorge;
USE loja_do_jorge;

CREATE TABLE IF NOT EXISTS produto(
	id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(80) NOT NULL,
  descricao TEXT NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS vendedor(
	id INT NOT NULL AUTO_INCREMENT,
  nome varchar(100) NOT NULL,
  salario DECIMAL(10,2) NOT NULL,
  
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS venda(
	id INT NOT NULL AUTO_INCREMENT,
  id_produto INT NOT NULL,
  id_vendedor INT NOT NULL,
  
  PRIMARY KEY(id),
  FOREIGN KEY (id_produto) REFERENCES produto(id),
  FOREIGN KEY (id_vendedor) REFERENCES vendedor(id)
);

-- Crie um usuário chamado 'jose' com a senha 'Jose@2024' e acesso local.
CREATE USER 'jose'@'localhost' IDENTIFIED BY 'Jose@2024';

-- Conceda ao usuário 'jose' permissão para SELECT e INSERT na tabela 'venda' do banco 'loja_do_jorge'.
GRANT SELECT, INSERT ON loja_do_jorge.venda TO 'jose'@'localhost';

-- Verifique os privilégios atribuídos ao usuário 'jose'.
SHOW GRANTS FOR 'jose'@'localhost';

-- Remova apenas o privilégio de INSERT do usuário 'jose' na tabela 'venda'.
REVOKE INSERT ON loja_do_jorge.venda FROM 'jose'@'localhost';

-- Conceda ao usuário 'jose' todos os privilégios no banco 'estoque'.
GRANT ALL PRIVILEGES ON loja_do_jorge TO 'jose'@'localhost';

-- Conceda a ele permissão de repassar os privilégios concedidos.
GRANT ALL PRIVILEGES ON loja_do_jorge TO 'jose'@'localhost' WITH GRANT OPTION;

-- Revogue todos os privilégios do usuário 'jose' no banco 'estoque'.
REVOKE ALL PRIVILEGES ON loja_do_jorge.* FROM 'jose'@'localhost';

-- Exclua o usuário 'jose'.
DROP USER 'jose'@'localhost';