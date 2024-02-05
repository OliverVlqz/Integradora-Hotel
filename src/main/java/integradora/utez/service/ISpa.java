package integradora.utez.service;


import integradora.utez.model.dto.SpaDto;
import integradora.utez.model.entity.SpaBean;

import java.util.List;

public interface ISpa {
    SpaBean save(SpaDto spaDto);

    SpaBean findById(Integer id);

    void delete (SpaBean spaBean);

    List<SpaBean> findAll();
}
