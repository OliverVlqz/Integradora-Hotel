package integradora.utez.service;

import integradora.utez.model.dto.ReservacionDto;
import integradora.utez.model.entity.ReservacionBean;

import java.util.List;

public interface IReservacion {
    ReservacionBean save(ReservacionDto reservacionDto);

    ReservacionBean findById(Integer id);

    void delete (ReservacionBean reservacionBean);

    List<ReservacionBean> findAll();


}

