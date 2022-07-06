package com.ids.Negocio.domain;

import lombok.CustomLog;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_employee")
    Long id;

    String surname;

    String firstname;

    @Column(name="id_country")
    Long idCountry;

    @Column(name="id_language")
    Long idLanguage;

    @ManyToOne
    @JoinColumn(name = "id_country", insertable = false, updatable = false)
    Country country;

    @ManyToOne
    @JoinColumn(name = "id_language", insertable = false,updatable = false)
    Language language;

}
