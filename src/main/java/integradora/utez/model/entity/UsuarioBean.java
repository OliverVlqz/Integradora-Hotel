package integradora.utez.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "usuarioBean")
    private Set<HistorialBean> historialBeans = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "usuarioBean")
    private Set<ReservacionBean> reservacionBeans = new HashSet<>();

}
