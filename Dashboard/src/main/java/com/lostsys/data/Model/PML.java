package com.lostsys.data.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pml")
public class PML {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nodo;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name="precio_marginal")
    private Float precio_marginal;

    @Column(name="comp_energia")
    private Float comp_energia;

    @Column(name="comp_perdidas")
    private Float comp_perdidas;

    @Column(name="comp_congestion")
    private Float comp_congestion;


}
