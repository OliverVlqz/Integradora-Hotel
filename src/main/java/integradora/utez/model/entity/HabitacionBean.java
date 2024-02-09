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
@Table(name = "Habitacion")
public class HabitacionBean {
    @Id
    @Column(name = "id_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_habitacion;
    @Column(name = "t_habitacion", nullable = false)
    private String t_habitacion;
    @Column(name = "costo", nullable = false)
    private String costo;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "descuento", nullable = false)
    private double descuento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reservacion")
    private ReservacionBean reservacionBean;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_tipohab")
    private TipoHabBean tipoHabBean;
}
