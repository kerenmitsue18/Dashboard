package com.lostsys.data.Model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pml")
public class PML {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nodo")
    private Long id_nodo;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name="precio_marginal")
    private Double precio_marginal;

    @Column(name="comp_energia")
    private Double comp_energia;

    @Column(name="comp_perdidas")
    private Double comp_perdidas;

    @Column(name="comp_congestion")
    private Double comp_congestion;


}
