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
@Table(name = "Empleado")
public class EmpleadoBean {
    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empleado;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "correo", nullable = false)
    private String correo;
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
    @Column(name = "tipo_empleado", nullable = false)
    private String tipo_empleado;
}
