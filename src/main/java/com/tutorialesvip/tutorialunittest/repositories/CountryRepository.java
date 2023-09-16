package com.tutorialesvip.tutorialunittest.repositories;

import com.tutorialesvip.tutorialunittest.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    //Buscar paises por Iso Code
    Country findCountryByIsoCode(String isoCode);
}
