package integradora.utez.service.Impl;

import integradora.utez.model.dao.RestauranteDao;
import integradora.utez.model.dto.RestauranteDto;
import integradora.utez.model.entity.RestauranteBean;
import integradora.utez.service.IRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplRestaurante implements IRestaurante {
    @Autowired
    RestauranteDao restauranteDao;
    @Override
    public RestauranteBean save (RestauranteDto restauranteDto){
        RestauranteBean restauranteBean = RestauranteBean.builder()
                .id_restaurante(restauranteDto.getId_restaurante())
                .nombre(restauranteDto.getNombre())
                .descripcion(restauranteDto.getDescripcion())
                .precio(restauranteDto.getPrecio())
                .descuento(restauranteDto.getDescuento())
                .build();
        return restauranteDao.save(restauranteBean);

    }
    @Override
    public RestauranteBean findById(Integer id){
        return restauranteDao.findById(id).orElse(null);}
    @Override
    public void delete (RestauranteBean restauranteBean) {
        restauranteDao.delete(restauranteBean);}
    @Override
    public List<RestauranteBean> findAll(){
        return (List<RestauranteBean>) restauranteDao.findAll();}

}
