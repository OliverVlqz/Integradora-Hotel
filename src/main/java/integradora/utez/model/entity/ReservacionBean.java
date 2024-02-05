package integradora.utez.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
}
