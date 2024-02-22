package integradora.utez.model.dto;
import integradora.utez.model.entity.PaquetesBean;
import integradora.utez.model.entity.ReservacionBean;
import integradora.utez.model.entity.UsuarioBean;
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
    private String paquete;
    private String total;
    private ReservacionBean reservacionBean;
    private PaquetesBean paquetesBean;
    private UsuarioBean usuarioBean;

}
