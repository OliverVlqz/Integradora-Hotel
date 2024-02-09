package integradora.utez.controller;

import integradora.utez.model.dto.EmpleadoDto;
import integradora.utez.model.entity.EmpleadoBean;
import integradora.utez.service.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    private IEmpleado empleadoService;

    @GetMapping("/")
    public List<EmpleadoBean> getCliente() {
        return empleadoService.findAll();
    }

    @GetMapping("/{id}")
    public EmpleadoBean showById(@PathVariable Integer id) {
        return empleadoService.findById(id);
    }

    @PostMapping("/")
    public EmpleadoDto create(@RequestBody EmpleadoDto empleadoDto) {
        EmpleadoBean empleadoSave = empleadoService.save(empleadoDto);
        return EmpleadoDto.builder()
                .id_empleado(empleadoSave.getId_empleado())
                .nombre(empleadoSave.getNombre())
                .correo(empleadoSave.getCorreo())
                .contrasena(empleadoSave.getContrasena())
                .tipo_empleado(empleadoSave.getTipo_empleado())
                .build();
    }

    @PutMapping("/{id}")
    public EmpleadoDto update(@RequestBody EmpleadoDto empleadoDto) {
        EmpleadoBean empleadoUpdate = empleadoService.save(empleadoDto);
        return EmpleadoDto.builder()
                .id_empleado(empleadoUpdate.getId_empleado())
                .nombre(empleadoUpdate.getNombre())
                .correo(empleadoUpdate.getCorreo())
                .contrasena(empleadoUpdate.getContrasena())
                .tipo_empleado(empleadoUpdate.getTipo_empleado())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        EmpleadoBean empleado = empleadoService.findById(id);
        empleadoService.delete(empleado);
    }
}
