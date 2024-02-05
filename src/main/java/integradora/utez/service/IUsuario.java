package integradora.utez.service;

import integradora.utez.model.dto.SpaDto;
import integradora.utez.model.dto.UsuarioDto;
import integradora.utez.model.entity.SpaBean;
import integradora.utez.model.entity.UsuarioBean;

import java.util.List;

public interface IUsuario {
    UsuarioBean save(UsuarioDto usuarioDto);

    UsuarioBean findById(Integer id);

    void delete (UsuarioBean usuarioBean);

    List<UsuarioBean> findAll();
}
