package integradora.utez.service;


import integradora.utez.model.dto.HistorialDto;
import integradora.utez.model.entity.HistorialBean;


import java.util.List;

public interface IHistorial {
    HistorialBean save(HistorialDto historialDto);

    HistorialBean findById(Integer id);

    void delete (HistorialBean historialBean);

    List<HistorialBean> findAll();
}
