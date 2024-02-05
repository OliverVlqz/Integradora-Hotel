package integradora.utez.model.dao;

import integradora.utez.model.entity.EmpleadoBean;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoDao extends CrudRepository<EmpleadoBean, Integer> {
}
