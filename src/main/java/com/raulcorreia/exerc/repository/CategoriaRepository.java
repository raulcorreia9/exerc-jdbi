package com.raulcorreia.exerc.repository;


import com.raulcorreia.exerc.model.Categoria;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

@UseClasspathSqlLocator(stripComments = false)
public interface CategoriaRepository {

    @SqlQuery
    @RegisterBeanMapper(Categoria.class)
    Categoria buscarPorId(@Bind("categoriaId") Long categoriaId);

}
