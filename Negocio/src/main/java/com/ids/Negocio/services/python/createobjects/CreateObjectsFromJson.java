package com.ids.Negocio.services.python.createobjects;

import com.ids.Negocio.domain.Airport;
import com.ids.Negocio.domain.Country;
import com.ids.Negocio.domain.Employee;
import com.ids.Negocio.domain.Language;

import java.util.List;

public interface CreateObjectsFromJson {
    List<Employee> ReturnEmployees();
    List<Airport> ReturnAirports();
    List<Country> ReturnCountries();
    List<Language> ReturnLanguage();

}
