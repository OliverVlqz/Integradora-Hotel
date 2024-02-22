package integradora.utez.service.Impl;

import integradora.utez.model.dao.HabitacionDao;
import integradora.utez.model.dto.HabitacionDto;
import integradora.utez.model.entity.HabitacionBean;
import integradora.utez.service.IHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplHabitacion implements IHabitacion {
    @Autowired
    HabitacionDao habitacionDao;

    @Override
    public HabitacionBean save(HabitacionDto habitacionDto){
        HabitacionBean habitacionBean = HabitacionBean.builder()
                .id_habitacion(habitacionDto.getId_habitacion())
                .t_habitacion(habitacionDto.getT_habitacion())
                .costo(habitacionDto.getCosto())
                .status(habitacionDto.getStatus())
                .descuento(habitacionDto.getDescuento())
                .build();
    return  habitacionDao.save(habitacionBean);
    }
@Override
    public HabitacionBean findById(Integer id){ return habitacionDao.findById(id).orElse(null);}

   public void delete (HabitacionBean habitacionBean){habitacionDao.delete(habitacionBean);}

    public List<HabitacionBean> findAll(){return (List<HabitacionBean>) habitacionDao.findAll();}
}
