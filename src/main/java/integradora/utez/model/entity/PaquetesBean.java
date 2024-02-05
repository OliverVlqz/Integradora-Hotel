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
@Table(name = "Paquetes")
public class PaquetesBean {
    @Id
    @Column(name = "id_paquetes")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_paquetes;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "costo", nullable = false)
    private String costo;
}
