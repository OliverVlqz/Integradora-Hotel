package integradora.utez.controller;


import integradora.utez.model.dto.SpaDto;
import integradora.utez.model.dto.UsuarioDto;
import integradora.utez.model.entity.EmpleadoBean;
import integradora.utez.model.entity.SpaBean;
import integradora.utez.model.entity.TipoHabBean;
import integradora.utez.model.entity.UsuarioBean;
import integradora.utez.service.ISpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spa")
public class SpaController {
    @Autowired
    ISpa spaService;

    @GetMapping("/")
    public List<SpaBean> findAll() {
        try {
            return spaService.findAll();
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener el tipo de Habitacion: ", ex);
        }
    }

    @GetMapping("/{id}")
    public SpaBean showById(@PathVariable Integer id){
        try {
            return spaService.findById(id);
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener el usuario: ", ex);
        }
    }

    @PostMapping("/")
    public SpaDto create(@RequestBody SpaDto spaDto){
        SpaBean spaSave = spaService.save(spaDto);
        return spaDto.builder()
                .id_spa(spaSave.getId_spa())
                .nombre(spaSave.getNombre())
                .descripcion(spaSave.getDescripcion())
                .precio(spaSave.getPrecio())
                .descuento(spaSave.getDescuento())
                .build();
    }

    @PutMapping("/{id}")
    public SpaDto update(@RequestBody SpaDto spaDto){
        SpaBean spaUpdate = spaService.save(spaDto);
        return spaDto.builder()
                .id_spa(spaUpdate.getId_spa())
                .nombre(spaUpdate.getNombre())
                .descripcion(spaUpdate.getDescripcion())
                .precio(spaUpdate.getPrecio())
                .descuento(spaUpdate.getDescuento())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        SpaBean spa = spaService.findById(id);
        spaService.delete(spa);
    }
}
