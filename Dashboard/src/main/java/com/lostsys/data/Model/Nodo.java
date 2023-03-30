package com.lostsys.data.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Nodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nodo;
    private String clave;
    private String nombre_nodo;
    private float longitud;

    private float latitud;

    private int id_sistema;


}
