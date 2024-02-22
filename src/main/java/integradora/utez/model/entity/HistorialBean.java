package integradora.utez.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Historial")
public class HistorialBean {
    @Id
    @Column(name = "id_Historial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Historial;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Column(name = "m_pago", nullable = false)
    private String m_pago;
    @Column(name = "paquete", nullable = false)
    private String paquete;
    @Column(name = "total", nullable = false)
    private String total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioBean usuarioBean;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "reservacion_id")
    @JsonIgnore
    private ReservacionBean reservacionBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paquetes_id")
    private PaquetesBean paquetesBean;

}
