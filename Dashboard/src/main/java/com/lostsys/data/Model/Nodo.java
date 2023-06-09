package com.lostsys.data.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "nodo")
public class Nodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nodo;
    @Column(name = "clave", nullable = false)
    private String clave;
    @Column(name = "nombre_nodo", nullable = false)
    private String nombre_nodo;
    @Column(name = "longitud", nullable = false)
    private float longitud;

    @Column(name = "latitud", nullable = false)
    private float latitud;

    @ManyToOne
    @JoinColumn(name = "id_carga")
    Carga carga;

    @ManyToOne
    @JoinColumn(name = "id_distribucion")
    Distribucion distribucion;

    @ManyToOne
    @JoinColumn(name = "id_sistema")
    Sistema sistema;


}
