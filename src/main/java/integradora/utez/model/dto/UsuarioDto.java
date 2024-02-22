package integradora.utez.model.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsuarioDto {
    private Integer id_usuario;
    private String nombre;
    private String contrasena;
    private String tipo_user;
    private String recurrencia;
}
