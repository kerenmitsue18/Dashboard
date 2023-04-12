package com.lostsys.data.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "zona_distribucion")
public class Distribucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_distribucion;

    @Column(name = "zona_distribucion", nullable = false)
    private String zona_distribucion;

}
