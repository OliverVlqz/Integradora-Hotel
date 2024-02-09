package integradora.utez.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TipoHabDto {
    private Integer id_tipodeHab;
    private String t_descripcion;
    private String t_cama;
    private String t_almohada;
}
