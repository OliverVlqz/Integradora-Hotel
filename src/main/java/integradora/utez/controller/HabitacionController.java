package integradora.utez.controller;

import integradora.utez.model.dto.HabitacionDto;
import integradora.utez.model.entity.HabitacionBean;
import integradora.utez.service.IHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {
    @Autowired
    private IHabitacion habitacionService;

    @GetMapping("/")
    public List<HabitacionBean> getHabitacion(){return habitacionService.findAll();}

    @GetMapping("/{id}")
    public  HabitacionBean showById(@PathVariable Integer id){return  habitacionService.findById(id);}

    @PostMapping("/")
    public  HabitacionBean create (@RequestBody HabitacionDto habitacionDto){return habitacionService.save(habitacionDto);}

    @PutMapping("/{id}")
    public HabitacionBean update (@PathVariable Integer id, @RequestBody HabitacionDto habitacionDto){
        HabitacionBean habitacionBean =habitacionService.findById(id);
        if(habitacionBean != null){
            habitacionDto.setId_habitacion(id);
            return habitacionService.save(habitacionDto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void  delete (@PathVariable Integer id){
        HabitacionBean habitaciones =habitacionService.findById(id);
        if (habitaciones != null){
            habitacionService.delete(habitaciones);
        }
    }

}
