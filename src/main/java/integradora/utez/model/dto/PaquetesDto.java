package integradora.utez.model.dto;

import integradora.utez.model.entity.RestauranteBean;
import integradora.utez.model.entity.SpaBean;
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
    private SpaBean spaBean;
    private RestauranteBean restauranteBean;
    }
