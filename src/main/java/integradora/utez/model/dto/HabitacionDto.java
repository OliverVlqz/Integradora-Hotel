package integradora.utez.model.dto;

import integradora.utez.model.entity.ReservacionBean;
import integradora.utez.model.entity.TipoHabBean;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class HabitacionDto {
    private Integer id_habitacion;
    private String t_habitacion;
    private String costo;
    private String status;
    private double descuento;
    private ReservacionBean reservacionBean;
    private TipoHabBean tipoHabBean;


}
