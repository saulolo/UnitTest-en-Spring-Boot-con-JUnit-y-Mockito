package com.tutorialesvip.tutorialunittest.controller;

import com.tutorialesvip.tutorialunittest.models.Country;
import com.tutorialesvip.tutorialunittest.models.CountryResponse;
import com.tutorialesvip.tutorialunittest.repositories.CountryRepository;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class IndependencyControllerTest {

    //Los mocks se usan para definir el comportamiento que deberían tener los métodos o
    //funciones del objeto simulado. Por ejemplo, cuando mockeas un repositorio, puedes definir
    //cómo debe comportarse cuando se llame a un método específico, como findCountryByIsoCode.
    @Mock
    private CountryRepository countryRepositoryMock;

    //Esta anotación se usa para inyectar dependencias de Spring en tus pruebas. Cuando necesitas
    //una instancia real de una clase administrada por Spring en tus pruebas, como un controlador,
    // un servicio o un componente, para que Spring inyecte esa instancia en tu prueba. Esto te
    // permite trabajar con la instancia real en lugar de una simulación (mock).
    //En resumen, @Mock se usa para crear objetos simulados de las clases que necesitas, y
    //@InjectMocks se utiliza para inyectar automáticamente esos mocks en la clase bajo prueba.

    @Autowired
    private IndependencyController independencyController;

    @InjectMocks
    private DiferenciaEntreFechas diferenciaEntreFechas;

    @Mock
    private CountryResponse countryResponse;

    @Mock
    private Country country;


    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Prueba para verificar la respuesta de getCountryDetails cuando el pais existe")
    void getCountryDetailsCuandoElPaisExiste() {

        // Given (configura los mocks antes de la prueba)
        Country countryMock = new Country();
        countryMock.setIsoCode("DO");
        countryMock.setCountryIdependenceDate("27/02/1844");
        countryMock.setCountryId(1L);
        countryMock.setCountryName("República Dominicana");
        countryMock.setCountryCapital("Santo Domingo");

        // When (ejecuta la acción que deseas probar)
        ResponseEntity<CountryResponse> respuesta = independencyController.getCountryDetails("DO");

        // Then (verifica que la respuesta sea la esperada)
        assertEquals(HttpStatus.OK, respuesta.getStatusCode()); // Verifica el estado HTTP
        assertNotNull(respuesta.getBody()); // Verifica que el cuerpo de la respuesta no sea nulo

        assertEquals("República Dominicana", respuesta.getBody().getCountryName());
        assertEquals("Santo Domingo", respuesta.getBody().getCapitalName());

    }

    @Test
    @DisplayName("Prueba para verificar la respuesta de getCountryDetails cuando el pais NO exista")
    void getCountryDetailsCuandoElNoPaisExiste() {

        // Given (configura los mocks antes de la prueba)
        Country countryMock = new Country();
        countryMock.setIsoCode("DO");
        countryMock.setCountryIdependenceDate("27/02/1844");
        countryMock.setCountryId(1L);
        countryMock.setCountryName("República Dominicana");
        countryMock.setCountryCapital("Santo Domingo");

        // When (ejecuta la acción que deseas probar)
        //aqui pongo uno que no exista, por ejemplo IT
        ResponseEntity<CountryResponse> respuesta = independencyController.getCountryDetails("IT");

        // Then (verifica que la respuesta sea la esperada en este caso nula porque no existe ese IsoCode)
        assertNull(respuesta.getBody().getCountryName());

    }


}