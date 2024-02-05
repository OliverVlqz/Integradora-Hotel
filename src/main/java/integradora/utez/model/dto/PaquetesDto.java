package integradora.utez.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PaquetesDto {
    private Integer id_paquetes;
    private String nombre;
    private String descripcion;
    private String costo;

}
