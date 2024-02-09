package integradora.utez.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "Reservacion")
public class ReservacionBean {
    @Id
    @Column(name = "id_reservacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reservacion;
    @Column(name = "f_entrada", nullable = false)
    private Date f_entrada;
    @Column(name = "f_salida", nullable = false)
    private Date f_salida;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "reservacionBean")
    private Set<HabitacionBean> habitaciones = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioBean usuarioBean;

    @OneToOne(mappedBy = "reservacionBean", cascade = CascadeType.ALL)
    private HistorialBean historialBean;
}
