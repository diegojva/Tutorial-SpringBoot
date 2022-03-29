package com.practice.spring.practice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="nombres", nullable = false, length = 50)
    private String nombre;

    @Column (name="apellidos", nullable = false, length = 50)
    private String apellido;

    @Column (name="email", nullable = false, length = 150)
    private String email;

    @Column (name="telefono", nullable = false, length = 50)
    private String telefono;

    @Column (name="password", nullable = false, length = 200)
    private String password;

}
