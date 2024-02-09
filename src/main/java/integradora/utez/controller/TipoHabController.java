package integradora.utez.controller;

import integradora.utez.model.dto.TipoHabDto;
import integradora.utez.model.entity.TipoHabBean;
import integradora.utez.service.ITipoHab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tipoHab")
public class TipoHabController {
    @Autowired
    private  ITipoHab tipoHabService;

    @PostMapping("/")
    public TipoHabDto create(@RequestBody TipoHabDto tipoHabDto){
        TipoHabBean tipoHabSave = tipoHabService.save(tipoHabDto);
        return tipoHabDto.builder()
                .id_tipodeHab(tipoHabSave.getId_tipodeHab())
                .t_descripcion(tipoHabSave.getT_descripcion())
                .t_cama(tipoHabSave.getT_cama())
                .t_almohada(tipoHabSave.getT_almohada())
                .build();
    }
    @PutMapping("/")
    public TipoHabDto update (@RequestBody TipoHabDto tipoHabDto) {
        TipoHabBean tipodeHabUpdate = tipoHabService.save(tipoHabDto);
        return tipoHabDto.builder()
                .id_tipodeHab(tipodeHabUpdate.getId_tipodeHab())
                .t_descripcion(tipodeHabUpdate.getT_descripcion())
                .t_cama(tipodeHabUpdate.getT_cama())
                .t_almohada(tipodeHabUpdate.getT_almohada())
                .build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            TipoHabBean tipodeHab = tipoHabService.findById(id);
            tipoHabService.delete(tipodeHab);
            return new ResponseEntity<>(tipodeHab   , HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex){
            response.put("msj", ex.getMessage());
            response.put("TipodeHabitacion", id);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")

    public TipoHabBean showById(@PathVariable Integer id){
        try {
            return tipoHabService.findById(id);
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener el tipo de Habitacion: ", ex);
        }
    }

    @GetMapping("/")
    public List<TipoHabBean> findAll() {
        try {
            return tipoHabService.findAll();
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener el tipo de Habitacion: ", ex);
        }
    }
}
