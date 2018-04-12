package Survey.Api.controller.services;

import Survey.Api.model.dao.RegistroTRecorridoDao;
import Survey.Api.model.dao.TRecorridosEncuestaDao;
import Survey.Api.model.entity.db.RegistroTRecorridos;
import Survey.Api.model.entity.db.TRecorridosEncuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncuestaTiemposRecorridoServicio {

    @Autowired
    private RegistroTRecorridoDao registroTRecorridoDao;

    @Autowired
    private TRecorridosEncuestaDao tRecorridosEncuestaDao;

    public EncuestaTiemposRecorridoServicio() {
    }


    public void addTiempoRecorridos(TRecorridosEncuesta t_recorridos) {
        tRecorridosEncuestaDao.addTRecorridoEncuesta(t_recorridos);
    }

    public void addRegistroTiempoRecorridos(RegistroTRecorridos registro) {
        registroTRecorridoDao.addRegistroTRecorridoEncuesta(registro);
    }
}
