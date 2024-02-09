package integradora.utez.service.Impl;

import integradora.utez.model.dao.TipoHabDao;
import integradora.utez.model.dto.TipoHabDto;
import integradora.utez.model.entity.TipoHabBean;
import integradora.utez.service.ITipoHab;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplTipoHab implements ITipoHab {

        private final TipoHabDao tipoHabDao;
        @Transactional
        @Override
        public TipoHabBean save(TipoHabDto tipoHabDto) {
            TipoHabBean tipoHab = TipoHabBean.builder()
                    .id_tipodeHab(tipoHabDto.getId_tipodeHab())
                    .t_descripcion(tipoHabDto.getT_descripcion())
                    .t_cama(tipoHabDto.getT_cama())
                    .t_almohada(tipoHabDto.getT_almohada())
                    .build();
            return tipoHabDao.save(tipoHab);
        }

        @Transactional(readOnly = true)
        @Override
        public TipoHabBean findById(Integer id) {
            return tipoHabDao.findById(id).orElse(null);
        }

        @Transactional
        @Override
        public void delete(TipoHabBean tipoHabBean) {
            tipoHabDao.delete(tipoHabBean);
        }

        @Transactional
        @Override
        public List<TipoHabBean> findAll() {
            return (List<TipoHabBean>) tipoHabDao.findAll();
        }


}
