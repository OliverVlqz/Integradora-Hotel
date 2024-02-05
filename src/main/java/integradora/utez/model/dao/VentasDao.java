package integradora.utez.model.dao;

import integradora.utez.model.entity.VentasBean;
import org.springframework.data.repository.CrudRepository;

public interface VentasDao extends CrudRepository<VentasBean,Integer> {
}
