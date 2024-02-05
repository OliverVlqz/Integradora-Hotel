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
@Table(name = "Historial")
public class HistorialBean {
    @Id
    @Column(name = "idHistorial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ventas;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Column(name = "m_pago", nullable = false)
    private String m_pago;
    @Column(name = "total", nullable = false)
    private String total;
}
