package integradora.utez.model.dto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class HistorialDto {
    private Integer id_Historial;
    private String nombre;
    private Date fecha;
    private String m_pago;
    private String total;
}
