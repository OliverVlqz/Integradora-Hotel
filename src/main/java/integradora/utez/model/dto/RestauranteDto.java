package integradora.utez.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RestauranteDto {
    private Integer id_restaurante;
    private String nombre;
    private String descripcion;
    private String precio;
    private Integer  descuento;
}
