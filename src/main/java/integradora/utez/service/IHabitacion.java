package integradora.utez.service;
import integradora.utez.model.dto.EmpleadoDto;
import integradora.utez.model.dto.HabitacionDto;
import integradora.utez.model.entity.HabitacionBean;

import java.util.List;

public interface IHabitacion {
    HabitacionBean save(HabitacionDto habitacionDto);

    HabitacionBean findById(Integer id);

    void delete (HabitacionBean habitacionBean);

    List<HabitacionBean> findAll();
}
