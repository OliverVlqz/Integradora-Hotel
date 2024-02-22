package integradora.utez.controller;



import integradora.utez.model.dto.ReservacionDto;
import integradora.utez.model.entity.ReservacionBean;
import integradora.utez.service.Impl.ImplReservacion;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/reservacion")
public class ReservacionController {

    private final ImplReservacion reservacionService;

    public ReservacionController(ImplReservacion reservacionService) {
        this.reservacionService = reservacionService;
    }

    @PostMapping("/client")
    public ResponseEntity<?> create(@RequestBody ReservacionDto reservacionDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            ReservacionBean clientSave = reservacionService.save(reservacionDto);
            response.put("mensaje", "Cliente creado correctamente");
            response.put("Client", clientSave);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Error al crear el cliente");
            response.put("Cliente", null);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/client")
    public ReservacionDto update(@RequestBody ReservacionDto reservacionDto) {
        ReservacionBean reservacionUpdate = reservacionService.save(reservacionDto);
        return reservacionDto.builder()
                .id_reservacion(reservacionDto.getId_reservacion())
                .f_entrada(reservacionDto.getF_entrada())
                .f_salida(reservacionDto.getF_salida())
                .usuario_id(reservacionDto.getUsuario_id())
                .build();
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            ReservacionBean client = reservacionService.findById(id);
            reservacionService.delete(client);
            response.put("mensaje", "Empleado eliminado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el empleado");
            response.put("Empleado", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/client/{id}")
    public ReservacionBean findById(@PathVariable Integer id) {
        try {
            return reservacionService.findById(id);
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }
    }

    @GetMapping("/client")
    public List<ReservacionBean> findAll() {
        try {
            return reservacionService.findAll();
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }
    }
}
