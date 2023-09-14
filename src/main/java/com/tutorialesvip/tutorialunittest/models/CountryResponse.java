package com.tutorialesvip.tutorialunittest.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse {


    private String countryName;
    private String capitalName;
    private String independenceDate;
    private int yearsOfIndependency;
    private int monthsOfIndependency;
    private int dayssOfIndependency;


}
