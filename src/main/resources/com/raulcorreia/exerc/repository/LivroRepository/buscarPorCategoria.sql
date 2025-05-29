SELECT
    l.id,
    l.titulo,
    l.autor,
    c.nome AS categoria
FROM
    livro l
        INNER JOIN
    categoria c ON l.categoria_id = c.id
WHERE
    LOWER(c.nome) = LOWER(:categoriaNome);