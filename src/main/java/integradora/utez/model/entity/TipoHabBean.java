package integradora.utez.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "TipodeHabitacion")
public class TipoHabBean {
    @Id
    @Column(name = "id_tipodeHab")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipodeHab;
    @Column(name = "t_descripcion", nullable = false)
    private String t_descripcion;
    @Column(name = "t_cama", nullable = false)
    private String t_cama;
    @Column(name = "t_almohada", nullable = false)
    private String t_almohada;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tipoHabBean")
    private HabitacionBean habitacionBean;}
