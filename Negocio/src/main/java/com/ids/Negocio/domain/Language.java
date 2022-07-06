package com.ids.Negocio.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="language_table")
public class Language {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_language")
    Long id;

    @Column(name="language_code")
    String code;

    @Column(name="language_name")
    String name;

    @OneToMany(mappedBy = "language")
    List<Employee> employees;
}
