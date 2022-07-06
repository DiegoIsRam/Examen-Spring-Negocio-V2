package com.ids.Negocio.services.python.getdata;

import com.ids.Negocio.domain.JsonPython;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class GetDateFromPythonServiceImpl implements GetDataFromPythonService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<JsonPython> GetDataFromPython() {
        JsonPython[] empleadosJSON=restTemplate.getForObject(
                "http://localhost:5000/clientes",
                JsonPython[].class
        );

         List<JsonPython> listaEmpleados = Arrays.asList(empleadosJSON);
        System.out.println(listaEmpleados);
        return  listaEmpleados;
    }


}
