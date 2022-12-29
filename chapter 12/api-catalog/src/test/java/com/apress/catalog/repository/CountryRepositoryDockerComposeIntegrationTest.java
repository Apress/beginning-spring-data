package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@Testcontainers
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryRepositoryDockerComposeIntegrationTest {

    private static final Integer POSTGRES_PORT = 5032;
    @Autowired
    CountryRepository countryRepository;


    private static final DockerComposeContainer environment =
            new DockerComposeContainer(new File("src/test/resources/docker-compose.yml"))
                    .withExposedService("postgres", POSTGRES_PORT, Wait.forListeningPort())
                    .withLocalCompose(true);

    @BeforeAll
    public static void setUp() {
        environment.start();
    }

    @AfterAll
    public static void tearDown() {
        environment.stop();
    }

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        String postgresUrl = environment.getServiceHost("postgres", POSTGRES_PORT)
                + ":" + environment.getServicePort("postgres", POSTGRES_PORT);

        registry.add("spring.datasource.url", () -> "jdbc:postgresql://" + postgresUrl + "/catalog");
        registry.add("spring.datasource.username", () -> "postgres");
        registry.add("spring.datasource.password", () -> "postgres");
    }

    //@Test
    public void should_get_a_country() {
        Optional<Country> country = countryRepository.findById(1L);

        assertAll(
                ()-> assertTrue(country.isPresent()),
                ()-> assertEquals("AR", country.get().getCode())
        );
    }
}