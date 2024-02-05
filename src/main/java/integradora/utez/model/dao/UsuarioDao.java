package integradora.utez.model.dao;

import integradora.utez.model.entity.UsuarioBean;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<UsuarioBean,Integer> {
}
