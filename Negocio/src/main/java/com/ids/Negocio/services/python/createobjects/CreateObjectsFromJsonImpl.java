package com.ids.Negocio.services.python.createobjects;

import com.ids.Negocio.domain.*;
import com.ids.Negocio.services.python.getdata.GetDataFromPythonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CreateObjectsFromJsonImpl implements CreateObjectsFromJson{
    @Autowired
    GetDataFromPythonService getDataFromPythonService;
    @Override
    public List<Employee> ReturnEmployees() {
        List<JsonPython> listaEmpleados=getDataFromPythonService.GetDataFromPython();
        List<Employee> listaEmployee=new ArrayList<>();
        for (JsonPython empleado:
             listaEmpleados) {
            Employee employee=new Employee();
            employee.setFirstname(empleado.getFirstname());
            employee.setSurname(empleado.getSurname());
            employee.setIdCountry(Long.valueOf("1"));
            employee.setIdLanguage(Long.valueOf("1"));
            listaEmployee.add(employee);
        }
        return listaEmployee;
    }

    @Override
    public List<Airport> ReturnAirports() {
        List<JsonPython> listaEmpleados=getDataFromPythonService.GetDataFromPython();
        List<Airport> listaAeropuertos = new ArrayList<>();
        for (JsonPython aeropuerto:
             listaEmpleados) {
            Airport airport=new Airport();
            airport.setName(aeropuerto.getAirport());
            listaAeropuertos.add(airport);
        }
        return listaAeropuertos;
    }

    @Override
    public List<Country> ReturnCountries() {
        List<JsonPython> listaEmpleados=getDataFromPythonService.GetDataFromPython();
        List<Country> listapaises = new ArrayList<>();
        for (JsonPython pais:
                listaEmpleados) {
            Country country=new Country();
            country.setName(pais.getCountry());
            country.setCode("MEX83834");
            country.setIdAirport(Long.valueOf("1"));
            listapaises.add(country);
        }
        return listapaises;
    }

    @Override
    public List<Language> ReturnLanguage() {
        List<JsonPython> listaEmpleados=getDataFromPythonService.GetDataFromPython();
        List<Language> listalenguages = new ArrayList<>();
        for (JsonPython lenguage:
                listaEmpleados) {
            Language language=new Language();
            language.setName(lenguage.getLanguage());
            language.setCode("ESP37D7");
            listalenguages.add(language);
        }
        return listalenguages;
    }
}
