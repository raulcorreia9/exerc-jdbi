package com.raulcorreia.exerc.repository;

import com.raulcorreia.exerc.dto.LivroCategoriaDTO;
import com.raulcorreia.exerc.model.Livro;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;


@UseClasspathSqlLocator(stripComments = false)
public interface LivroRepository {

    @SqlUpdate
    @GetGeneratedKeys
    Long inserirLivro(@BindBean("livro") Livro livro);

    @SqlQuery
    @RegisterBeanMapper(LivroCategoriaDTO.class)
    List<LivroCategoriaDTO> buscarPorCategoria(@Bind("categoriaNome") String categoriaNome);


}
