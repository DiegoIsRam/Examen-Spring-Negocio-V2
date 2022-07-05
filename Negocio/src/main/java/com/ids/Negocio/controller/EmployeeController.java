package com.ids.Negocio.controller;

import com.ids.Negocio.domain.Employee;
import com.ids.Negocio.services.employee.EmployeeService;
import com.ids.Negocio.services.pythonconnect.PythonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PythonService pythonService;
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

    @GetMapping("/employee/add/")
     public String mostrarDesdePython(){
        List<Employee> employeeList= pythonService.ObtenerEmpleadosFromPython();
        for ( Employee empleado:
             employeeList) {
            employeeService.guardaEmpleado(empleado);
            System.out.println(empleado);
        }
        System.out.println(employeeList);
        return "redirect:/employee";

    }
}

