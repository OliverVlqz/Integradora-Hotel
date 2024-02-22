package integradora.utez.controller;


import integradora.utez.model.dto.UsuarioDto;
import integradora.utez.model.entity.UsuarioBean;
import integradora.utez.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private IUsuario usuarioService;

    @PostMapping("/")
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto){
        UsuarioBean usuarioSave = usuarioService.save(usuarioDto);
        return usuarioDto.builder()
                .id_usuario(usuarioSave.getId_usuario())
                .nombre(usuarioSave.getNombre())
                .contrasena(usuarioSave.getContrasena())
                .tipo_user(usuarioSave.getTipo_user())
                .recurrencia(usuarioSave.getRecurrencia())
                .build();
    }
    @PutMapping("/{id}")
    public UsuarioDto update (@RequestBody UsuarioDto usuarioDto) {
        UsuarioBean usuarioUpdate = usuarioService.save(usuarioDto);
        return usuarioDto.builder()
                .id_usuario(usuarioUpdate.getId_usuario())
                .nombre(usuarioUpdate.getNombre())
                .contrasena(usuarioUpdate.getContrasena())
                .tipo_user(usuarioUpdate.getTipo_user())
                .recurrencia(usuarioUpdate.getRecurrencia())
                .build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            UsuarioBean usuario = usuarioService.findById(id);
            usuarioService.delete(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex){
            response.put("msj", ex.getMessage());
            response.put("Usuario", id);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")

    public UsuarioBean showById(@PathVariable Integer id){
        try {
            return usuarioService.findById(id);
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener el usuario: ", ex);
        }
    }

    @GetMapping("/")
    public List<UsuarioBean> findAll() {
        try {
            return usuarioService.findAll();
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener el usuarion: ", ex);
        }
    }
}
