package integradora.utez.controller;

import integradora.utez.model.dto.HistorialDto;
import integradora.utez.model.entity.HistorialBean;
import integradora.utez.model.entity.PaquetesBean;
import integradora.utez.model.entity.ReservacionBean;
import integradora.utez.model.entity.UsuarioBean;
import integradora.utez.service.Impl.ImplHistorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    @Autowired
    private ImplHistorial implHistorial;

    @GetMapping("/{id}")
    public ResponseEntity<HistorialDto> getHistorialById(@PathVariable Integer id) {
        HistorialBean historialBean = implHistorial.findById(id);
        if (historialBean == null) {
            return ResponseEntity.notFound().build();
        }

        HistorialDto historialDto = new HistorialDto();
        historialDto.setId_Historial(historialBean.getId_Historial());
        historialDto.setNombre(historialBean.getNombre());
        historialDto.setFecha(historialBean.getFecha());
        historialDto.setM_pago(historialBean.getM_pago());
        historialDto.setTotal(historialBean.getTotal());

        UsuarioBean usuarioBean = historialBean.getUsuarioBean();
        if (usuarioBean != null) {
            historialDto.setNombre(usuarioBean.getNombre());
        }

        ReservacionBean reservacionBean = historialBean.getReservacionBean();
        if (reservacionBean != null) {
            historialDto.setFecha(reservacionBean.getF_entrada());
        }

        PaquetesBean paquetesBean = historialBean.getPaquetesBean();
        if (paquetesBean != null) {
            historialDto.setNombre(paquetesBean.getNombre());
        }

        return ResponseEntity.ok(historialDto);
    }

}

