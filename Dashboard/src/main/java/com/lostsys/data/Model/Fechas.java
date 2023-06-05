package com.lostsys.data.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "get_fechas")
public class Fechas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_pml", nullable = false)
    private LocalDate minFecha;

    @Column(name = "max_pml", nullable = false)
    private LocalDate maxFecha;


}
