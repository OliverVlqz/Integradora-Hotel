package integradora.utez.service.Impl;




import integradora.utez.model.dao.ReservacionDao;
import integradora.utez.model.dao.UsuarioDao;
import integradora.utez.model.dto.ReservacionDto;
import integradora.utez.model.entity.ReservacionBean;
import integradora.utez.model.entity.UsuarioBean;
import integradora.utez.service.IReservacion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class ImplReservacion implements IReservacion {

    private ReservacionDao reservacionService;
    private UsuarioDao usuarioService;

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public ReservacionBean save(ReservacionDto reservacionDto) {
        UsuarioBean usuario = usuarioService.findById(reservacionDto.getUsuario_id()).orElse(null);
        ReservacionBean reservacion = ReservacionBean.builder()
                .id_reservacion(reservacionDto.getId_reservacion())
                .f_entrada(reservacionDto.getF_entrada())
                .f_salida(reservacionDto.getF_salida())
                .usuarioBean(usuario)
                .build();
        return reservacionService.save(reservacion);
    }
    @Transactional(readOnly = true)
    @Override
    public ReservacionBean findById(Integer id) {
        return reservacionService.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(ReservacionBean card) {
        reservacionService.delete(card);
    }

    @Transactional
    @Override
    public List<ReservacionBean> findAll() {
        return (List<ReservacionBean>) reservacionService.findAll();
    }
}