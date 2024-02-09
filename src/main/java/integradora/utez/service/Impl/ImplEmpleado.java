package integradora.utez.service.Impl;

import integradora.utez.model.dao.EmpleadoDao;
import integradora.utez.model.dto.EmpleadoDto;
import integradora.utez.model.entity.EmpleadoBean;
import integradora.utez.service.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplEmpleado implements IEmpleado {
    @Autowired
    EmpleadoDao empleadoDao;
    @Override
    public EmpleadoBean save(EmpleadoDto empleadoDto) {
        EmpleadoBean empleadoBean = EmpleadoBean.builder()
                .id_empleado(empleadoDto.getId_empleado())
                .nombre(empleadoDto.getNombre())
                .correo(empleadoDto.getCorreo())
                .contrasena(empleadoDto.getContrasena())
                .tipo_empleado(empleadoDto.getTipo_empleado())
                .build();
        return empleadoDao.save(empleadoBean);
    }

    @Override
    public EmpleadoBean findById(Integer id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(EmpleadoBean empleadoBean) {
        empleadoDao.delete(empleadoBean);
    }

    @Override
    public List<EmpleadoBean> findAll() {
        return (List<EmpleadoBean>) empleadoDao.findAll();
    }
}
