package com.ids.Negocio.services.pythonconnect;

import com.ids.Negocio.domain.Employee;

import java.util.List;

public interface PythonService {
    List<Employee> ObtenerEmpleadosFromPython();
}
