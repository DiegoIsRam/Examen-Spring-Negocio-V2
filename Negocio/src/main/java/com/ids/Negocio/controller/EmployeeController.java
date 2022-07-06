package com.ids.Negocio.controller;

import com.ids.Negocio.domain.*;
import com.ids.Negocio.services.airport.AirportService;
import com.ids.Negocio.services.country.CountryService;
import com.ids.Negocio.services.employee.EmployeeService;
import com.ids.Negocio.services.language.LanguageService;
import com.ids.Negocio.services.python.createobjects.CreateObjectsFromJson;
import com.ids.Negocio.services.python.getdata.GetDataFromPythonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GetDataFromPythonService pythonService;
    @Autowired
    private CreateObjectsFromJson createObjectsFromJson;
    @Autowired
    private AirportService airportService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/employee")
    public String paginaEmployee(Model model){
        var employees=employeeService.listarEmpleados();
        model.addAttribute("employees",employees);
        return "employee"; //Ver la pagina HTML en Templates
    }
    @GetMapping("/employee/agregar")
    public String agregarEmployee(Employee employee){
        return "modificarEmployee";
    }
    @PostMapping("/employee/guardar")
    public String guardarEmployee(Employee employee){
        employeeService.guardaEmpleado(employee);
        return "redirect:/employee";
    }
    @GetMapping("/employee/editar/{id}")
    public String editarEmployee(Employee employee, Model model){
        employee=employeeService.encontraEmpleado(employee);
        model.addAttribute("employee",employee);
        return "modificarEmployee";
    }

    @GetMapping("/apiv1/clientes/add/")
     public String insertarDesdePython(){
        for (Country country:createObjectsFromJson.ReturnCountries()) {
            countryService.guardaPais(country);
        }
        for (Language language :createObjectsFromJson.ReturnLanguage()) {
            languageService.guardarIdioma(language);
        }
        for (Airport airport:createObjectsFromJson.ReturnAirports()) {
            airportService.guardarAeropuerto(airport);
        }
        for (Employee employee:createObjectsFromJson.ReturnEmployees()) {
            employeeService.guardaEmpleado(employee);
        }
        return "redirect:/employee";

    }
}

