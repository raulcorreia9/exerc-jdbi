package com.raulcorreia.exerc.config;

import com.raulcorreia.exerc.repository.CategoriaRepository;
import com.raulcorreia.exerc.repository.LivroRepository;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class JdbiConfiguration {

    @Bean
    public Jdbi jdbi(DataSource dataSource, List<JdbiPlugin> plugins, List<RowMapper<?>> rowmappers) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(dataSource);
        Jdbi jdbi = Jdbi.create(proxy);

        plugins.forEach(jdbi::installPlugin);
        rowmappers.forEach(jdbi::registerRowMapper);

        return jdbi;
    }

    @Bean
    public LivroRepository livroRepository(Jdbi jdbi) {
        return jdbi.onDemand(LivroRepository.class);
    }

    @Bean
    public CategoriaRepository categoriaRepository(Jdbi jdbi) {
        return jdbi.onDemand(CategoriaRepository.class);
    }

    @Bean
    public JdbiPlugin sqlObjectPlugin() {
        return new SqlObjectPlugin();
    }

}
