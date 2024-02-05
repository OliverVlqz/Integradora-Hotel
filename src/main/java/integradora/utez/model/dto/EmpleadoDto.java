package integradora.utez.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmpleadoDto {
    private Integer id_empleado;
    private String nombre;
    private String correo;
    private String contrasena;
    private String tipo_empleado;

}
