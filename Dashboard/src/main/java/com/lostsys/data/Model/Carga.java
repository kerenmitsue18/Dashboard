package com.lostsys.data.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "zona_carga")
public class Carga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carga;

    @Column(name = "zona_carga", nullable = false)
    private String zona_carga;
}
