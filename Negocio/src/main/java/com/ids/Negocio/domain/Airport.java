package com.ids.Negocio.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_airport")
    Long id;

    @Column(name="airport_name")
    String name;

    @ManyToOne
    @JoinColumn(name = "id_airport", insertable = false, updatable = false)
    Country countryAirport;
}
