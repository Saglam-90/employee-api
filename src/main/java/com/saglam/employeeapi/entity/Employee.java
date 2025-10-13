package com.saglam.employeeapi.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Employee-Entity.
 * Repräsentiert die "employee"-Tabelle in der Datenbank.
 *
 * JPA Annotationen:
 * @Entity        -> Kennzeichnet die Klasse als JPA Entity.
 * @Table         -> Legt optional den Tabellennamen fest.
 * @Id            -> Primärschlüssel.
 * @GeneratedValue-> Auto-Inkrementierung des Primärschlüssels (IDENTITY).
 * @Column        -> Legt optional Spaltennamen fest.
 *
 * Lombok Annotationen:
 * @Getter/@Setter -> Generiert Getter und Setter.
 * @NoArgsConstructor -> Leerer Konstruktor.
 * @AllArgsConstructor -> Konstruktor mit allen Feldern.
 * @ToString       -> Generiert automatisch die toString()-Methode.
 */
@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

}