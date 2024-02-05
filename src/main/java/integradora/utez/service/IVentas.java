package integradora.utez.service;

import integradora.utez.model.dto.VentasDto;
import integradora.utez.model.entity.VentasBean;

import java.util.List;

public interface IVentas {
    VentasBean save(VentasDto ventasDto);

    VentasBean findById(Integer id);

    void delete (VentasBean ventasBean);

    List<VentasBean> findAll();
}
