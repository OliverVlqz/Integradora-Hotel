package integradora.utez.service;

import integradora.utez.model.dto.RestauranteDto;
import integradora.utez.model.entity.RestauranteBean;

import java.util.List;

public interface IRestaurante {
    RestauranteBean save(RestauranteDto restauranteDto);

    RestauranteBean findById(Integer id);

    void delete (RestauranteBean restauranteBean);

    List<RestauranteBean> findAll();
}
