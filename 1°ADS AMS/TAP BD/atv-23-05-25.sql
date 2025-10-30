DELIMITER $
CREATE FUNCTION calcular_desconto(
    preco DECIMAL(10, 2),
    percentual_desconto DECIMAL(5, 2)
) RETURNS DECIMAL(10, 2) DETERMINISTIC 

BEGIN
    DECLARE desconto DECIMAL(10, 2);

    DECLARE preco_final DECIMAL(10, 2);

    -- Validação dos parâmetros
    IF preco IS NULL OR percentual_desconto IS NULL OR preco < 0 OR percentual_desconto < 0 OR percentual_desconto > 100 THEN 
        RETURN NULL; -- Retorna NULL para indicar um erro ou entrada inválida
    END IF;

    -- Calcula o valor do desconto
    SET desconto = preco * (percentual_desconto / 100);

    -- Calcula o preço final
    SET preco_final = preco - desconto;

    -- Retorna o preço final
    RETURN preco_final;

END
$

DELIMITER ;