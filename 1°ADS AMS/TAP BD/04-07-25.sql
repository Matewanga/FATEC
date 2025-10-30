-- 1. Criar usuário
CREATE USER 'nickolas'@'localhost' IDENTIFIED BY 'senha';

-- 2. Alterar senha
ALTER USER 'nickolas'@'localhost' IDENTIFIED BY 'nova_senha';

-- 3. Expirar senha em 60 dias
ALTER USER 'nickolas'@'localhost' PASSWORD EXPIRE INTERVAL 60 DAY;

-- 4. Limitar conexões por hora
ALTER USER 'nickolas'@'localhost' WITH MAX_CONNECTIONS_PER_HOUR 30;

-- 5. Limitar queries por hora
ALTER USER 'nickolas'@'localhost' WITH MAX_QUERIES_PER_HOUR 1000;

-- 6. Renomear usuário
RENAME USER 'nickolas'@'localhost' TO 'nickolas2'@'localhost';

-- 7. Removendo usuário
DROP USER 'nickolas';