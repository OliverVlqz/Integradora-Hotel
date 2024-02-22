package integradora.utez.service.Impl;

import integradora.utez.model.dao.HistorialDao;
import integradora.utez.model.dao.PaquetesDao;
import integradora.utez.model.dao.ReservacionDao;
import integradora.utez.model.dao.UsuarioDao;
import integradora.utez.model.dto.HistorialDto;
import integradora.utez.model.entity.HistorialBean;
import integradora.utez.model.entity.PaquetesBean;
import integradora.utez.model.entity.ReservacionBean;
import integradora.utez.model.entity.UsuarioBean;
import integradora.utez.service.IHistorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplHistorial implements IHistorial {
    @Autowired
    public HistorialDao historialDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private ReservacionDao reservacionDao;

    @Autowired
    private PaquetesDao paquetesDao;

    @Override
   public HistorialBean save(HistorialDto historialDto){

        UsuarioBean usuario = usuarioDao.findById(historialDto.getId_Historial()).orElse(null);
        ReservacionBean reservacion = reservacionDao.findById(historialDto.getId_Historial()).orElse(null);
        PaquetesBean paquete = paquetesDao.findById(historialDto.getId_Historial()).orElse(null);

        HistorialBean historialBean = HistorialBean.builder()
                .nombre(historialDto.getNombre())
                .fecha(historialDto.getFecha())
                .m_pago(historialDto.getM_pago())
                .total(historialDto.getTotal())
                .usuarioBean(usuario)
                .reservacionBean(reservacion)
                .paquetesBean(paquete)
                .build();

        return historialDao.save(historialBean);
    }

    @Override
   public HistorialBean findById(Integer id){return  historialDao.findById(id).orElse(null);}

    @Override
    public void delete (HistorialBean historialBean){historialDao.delete(historialBean);}

    @Override
    public List<HistorialBean> findAll(){return (List<HistorialBean>) historialDao.findAll();}

}
