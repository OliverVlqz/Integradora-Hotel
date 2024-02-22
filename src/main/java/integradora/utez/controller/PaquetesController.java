package integradora.utez.controller;

import integradora.utez.model.dto.PaquetesDto;
import integradora.utez.model.entity.PaquetesBean;
import integradora.utez.model.entity.RestauranteBean;
import integradora.utez.service.IPaquetes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/paquetes")
public class PaquetesController {
    @Autowired
    private IPaquetes paquetesService;

    @GetMapping("/")
    public List<PaquetesBean> getPaquete() {
        return paquetesService.findAll();
    }

    @GetMapping("/{id}")
    public PaquetesBean showById(@PathVariable Integer id) {
        return paquetesService.findById(id);
    }

    @PostMapping("/")
    public PaquetesBean create(@RequestBody PaquetesDto paquetesDto) {
        return paquetesService.save(paquetesDto);
    }

    @PutMapping("/{id}")
    public PaquetesBean update(@PathVariable Integer id, @RequestBody PaquetesDto paquetesDto) {
        PaquetesBean paquetesBean = paquetesService.findById(id);
        if (paquetesBean != null) {
            paquetesDto.setId_paquetes(id);
            return paquetesService.save(paquetesDto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        PaquetesBean paquetes = paquetesService.findById(id);
        if (paquetes != null) {
            paquetesService.delete(paquetes);
        }
    }
}
