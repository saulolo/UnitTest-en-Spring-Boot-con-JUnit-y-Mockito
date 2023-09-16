package com.tutorialesvip.tutorialunittest.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DiferenciaEntreFechasTest {

    @Mock
    private DiferenciaEntreFechas diferenciaEntreFechas;

    //Nota: A la hora de hacer pruebas unitarias, siempre vamos de lo más específico a lo mas
    //complicado, es por eso que arrancamos haciendo el test a la clase DiferenciaEntreFechas
    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateYearsOfIndependency() {
        //Given
        diferenciaEntreFechas = new DiferenciaEntreFechas();
        LocalDate today = LocalDate.now();
        String independenceDay = "27/02/1984";

        //When
        Period resultado = diferenciaEntreFechas.calculateYearsOfIndependency(independenceDay);

        //Then
        //verifica que los resultados sean los esperados
        assertEquals(19, resultado.getDays());
        assertEquals(6, resultado.getMonths());
        assertEquals(39, resultado.getYears());

    }
}