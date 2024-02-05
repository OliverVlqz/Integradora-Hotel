package integradora.utez.model.dto;

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
}
