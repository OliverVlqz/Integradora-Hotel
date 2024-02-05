package integradora.utez.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReservacionDto {
    private Integer id_reservacion;
    private Date f_entrada;
    private Date f_salida;
}
