package integradora.utez.service.Impl;

import integradora.utez.model.dao.SpaDao;
import integradora.utez.model.dto.SpaDto;
import integradora.utez.model.entity.SpaBean;
import integradora.utez.service.ISpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplSpa implements ISpa {
    @Autowired
    SpaDao spaDao;
    @Override
    public SpaBean save(SpaDto spaDto) {
        SpaBean spaBean = SpaBean.builder()
                .id_spa(spaDto.getId_spa())
                .nombre(spaDto.getNombre())
                .descripcion(spaDto.getDescripcion())
                .precio(spaDto.getPrecio())
                .descuento(spaDto.getDescuento())
                .build();
        return spaDao.save(spaBean);
    }

    @Override
    public SpaBean findById(Integer id) {
        return spaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(SpaBean spaBean) {
        spaDao.delete(spaBean);
    }

    @Override
    public List<SpaBean> findAll() {
        return (List<SpaBean>) spaDao.findAll();
    }
}
