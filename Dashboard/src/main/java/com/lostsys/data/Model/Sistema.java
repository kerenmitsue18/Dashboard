package com.lostsys.data.Model;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sistema")
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sistema;

    @Column(name = "nombre_sistema", nullable = false)
    private String nombre_sistema;
    @Column(name = "nomenclatura", nullable = false)
    private String nomenclatura;


}