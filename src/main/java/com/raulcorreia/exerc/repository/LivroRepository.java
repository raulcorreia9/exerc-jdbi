package com.raulcorreia.exerc.repository;

import com.raulcorreia.exerc.model.Livro;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository
@UseClasspathSqlLocator
public interface LivroRepository {

    @SqlUpdate
    @GetGeneratedKeys
    Long inserirLivro(@BindBean("livro") Livro livro);

}
