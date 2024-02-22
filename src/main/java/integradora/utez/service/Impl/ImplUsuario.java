package integradora.utez.service.Impl;


import integradora.utez.model.dao.UsuarioDao;
import integradora.utez.model.dto.UsuarioDto;
import integradora.utez.model.entity.UsuarioBean;
import integradora.utez.service.IUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplUsuario implements IUsuario {

    private final UsuarioDao usuarioDao;
    @Transactional
    @Override
    public UsuarioBean save(UsuarioDto usuarioDto) {
        UsuarioBean usuario = UsuarioBean.builder()
                .id_usuario(usuarioDto.getId_usuario())
                .nombre(usuarioDto.getNombre())
                .contrasena(usuarioDto.getContrasena())
                .tipo_user(usuarioDto.getTipo_user())
                .recurrencia(usuarioDto.getRecurrencia())
                .build();
        return usuarioDao.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioBean findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(UsuarioBean tipoHabBean) {
        usuarioDao.delete(tipoHabBean);
    }

    @Transactional
    @Override
    public List<UsuarioBean> findAll() {
        return (List<UsuarioBean>) usuarioDao.findAll();
    }


}
