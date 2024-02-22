package integradora.utez.service.Impl;

import integradora.utez.model.dao.PaquetesDao;
import integradora.utez.model.dto.PaquetesDto;
import integradora.utez.model.entity.PaquetesBean;
import integradora.utez.service.IPaquetes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplPaquetes implements IPaquetes {
    @Autowired
    PaquetesDao paquetesDao;

    @Override
   public PaquetesBean save(PaquetesDto paquetesDto){
        PaquetesBean paquetesBean = PaquetesBean.builder()
                .id_paquetes(paquetesDto.getId_paquetes())
                .nombre(paquetesDto.getNombre())
                .descripcion(paquetesDto.getDescripcion())
                .costo(paquetesDto.getCosto())
                .build();
        return paquetesDao.save(paquetesBean);
    }

    @Override
   public PaquetesBean findById(Integer id){return paquetesDao.findById(id).orElse(null);}

    @Override
    public void delete (PaquetesBean paquetesBean){paquetesDao.delete(paquetesBean);}
    @Override
   public List<PaquetesBean> findAll(){return (List<PaquetesBean>) paquetesDao.findAll();}
}
