package com.apress.catalog.repository.impl;

import com.apress.catalog.model.Country;
import com.apress.catalog.repository.CustomCountryRepository;
import com.datastax.oss.driver.api.core.cql.Statement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomCountryRepositoryImpl implements CustomCountryRepository {

    private CassandraOperations cassandraTemplate;

    public CustomCountryRepositoryImpl(CassandraOperations cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    @Override
    public Country save(Country entity) {
        return cassandraTemplate.insert(entity);
    }

    @Override
    public Optional<Country> findById(UUID id) {
        return Optional.of(cassandraTemplate.selectOneById(id, Country.class));
    }

    @Override
    public void deleteById(UUID id) {
        cassandraTemplate.deleteById(id, Country.class);
    }

    private void insertByDriver(Country entity) {
        //Equivalence using the driver
        Statement query = QueryBuilder
                .insertInto(toTableName(Country.class))
                .value("id", QueryBuilder.literal(entity.getId()))
                .value("code", QueryBuilder.literal(entity.getCode()))
                .value("name", QueryBuilder.literal(entity.getName()))
                .value("enabled", QueryBuilder.literal(entity.getEnabled()))
                .build();
        query.setTimeout(Duration.ofMillis(100L));

        cassandraTemplate.execute(query);
    }


    @SuppressWarnings("unused")
    private String toTableName(Object obj) {
        return toTableName(obj.getClass());
    }

    private String toTableName(Class<?> type) {

        Table tableAnnotation = type.getAnnotation(Table.class);

        return tableAnnotation != null && StringUtils.hasText(tableAnnotation.value())
                ? tableAnnotation.value()
                : type.getSimpleName();
    }
}
