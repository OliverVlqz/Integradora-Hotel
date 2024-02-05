package integradora.utez.service;


import integradora.utez.model.dto.EmpleadoDto;
import integradora.utez.model.entity.EmpleadoBean;

import java.util.List;

public interface IEmpleado {
    EmpleadoBean save(EmpleadoDto empleadoDto);

    EmpleadoBean findById(Integer id);

    void delete (EmpleadoBean empleadoBean);

    List<EmpleadoBean> findAll();
}
