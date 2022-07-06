package com.ids.Negocio.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_country")
    Long id;

    @Column(name="country_code")
    String code;

    @Column(name="country_name")
    String name;

    @Column(name="id_airport")
    Long idAirport;

    @OneToMany(mappedBy = "country")
    List<Employee> employees;

    @OneToMany(mappedBy = "countryAirport")
    List<Airport> airports;
}
