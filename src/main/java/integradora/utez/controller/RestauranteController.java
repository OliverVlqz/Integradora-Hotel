package integradora.utez.controller;

import integradora.utez.model.dto.RestauranteDto;
import integradora.utez.model.entity.RestauranteBean;
import integradora.utez.service.IRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {
    @Autowired
    private IRestaurante restService;
    @GetMapping("/")
    public List<RestauranteBean> getRestaurante(){return restService.findAll();}
    @GetMapping("/{id}")
    public RestauranteBean showById(@PathVariable Integer id){return restService.findById(id);}
    @PostMapping("/")
    public RestauranteDto create(@RequestBody RestauranteDto restauranteDto){
        RestauranteBean restauranteSave = restService.save(restauranteDto);
        return RestauranteDto.builder()
                .id_restaurante(restauranteSave.getId_restaurante())
                .nombre(restauranteSave.getNombre())
                .descripcion(restauranteSave.getDescripcion())
                .precio(restauranteSave.getPrecio())
                .descuento(restauranteSave.getDescuento())
.build();
    }
    @PutMapping("/")
    public RestauranteDto update(@RequestBody RestauranteDto restauranteDto){
        RestauranteBean restauranteSave = restService.save(restauranteDto);
        return RestauranteDto.builder()
                .id_restaurante(restauranteSave.getId_restaurante())
                .nombre(restauranteSave.getNombre())
                .descripcion(restauranteSave.getDescripcion())
                .precio(restauranteSave.getPrecio())
                .descuento(restauranteSave.getDescuento())
                .build();
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        RestauranteBean restaurante = restService.findById(id);
        restService.delete(restaurante);
    }
}
