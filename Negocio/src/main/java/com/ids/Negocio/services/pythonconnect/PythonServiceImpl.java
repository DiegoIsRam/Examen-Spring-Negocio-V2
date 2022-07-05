package com.ids.Negocio.services.pythonconnect;

import com.ids.Negocio.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class PythonServiceImpl implements PythonService{
/*
    public List<Movie> getMovies(){
        Movie[] me = restTemplate.getForObject(
                "http://services-movies/api/movies/",
                Movie[].class);
        List<Movie> m = Arrays.asList(me);
        return  m;
    }

 */

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Employee> ObtenerEmpleadosFromPython() {
        Employee[] me=restTemplate.getForObject(
                "http://localhost:5000/clientes",
                Employee[].class
        );
         List<Employee> m = Arrays.asList(me);
        return  m;
    }
}
