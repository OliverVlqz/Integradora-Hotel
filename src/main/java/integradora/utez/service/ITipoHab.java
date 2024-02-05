package integradora.utez.service;

import integradora.utez.model.dto.TipoHabDto;
import integradora.utez.model.entity.TipoHabBean;

import java.util.List;

public interface ITipoHab {
    TipoHabBean save(TipoHabDto tipoHabDto);

    TipoHabBean findById(Integer id);

    void delete (TipoHabBean tipoHabBean);

    List<TipoHabBean> findAll();

}
