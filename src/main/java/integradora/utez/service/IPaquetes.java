package integradora.utez.service;

import integradora.utez.model.dto.PaquetesDto;
import integradora.utez.model.entity.PaquetesBean;

import java.util.List;

public interface IPaquetes {
    PaquetesBean save(PaquetesDto paquetesDto);

    PaquetesBean findById(Integer id);

    void delete (PaquetesBean paquetesBean);

    List<PaquetesBean> findAll();
}

