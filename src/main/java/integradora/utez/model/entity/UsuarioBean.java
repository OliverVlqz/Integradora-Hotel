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
@Table(name = "Usuario")
public class UsuarioBean {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
    @Column(name = "tipo_user", nullable = false)
    private String tipo_user;
    @Column(name = "recurrencia", nullable = false)
    private String recurrencia;
}
