package integradora.utez.model.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SpaDto {
    private Integer id_spa;
    private String nombre;
    private String descripcion;
    private String precio;
    private Integer descuento;
}
