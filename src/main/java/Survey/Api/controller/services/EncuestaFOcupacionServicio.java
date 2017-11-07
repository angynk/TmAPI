package Survey.Api.controller.services;

import Survey.Api.model.dao.FOcupacionEncuestaDao;
import Survey.Api.model.dao.RegistroEncuestaFOcupacionDao;
import Survey.Api.model.entity.db.FOcupacionEncuesta;
import Survey.Api.model.entity.db.RegistroEncuestaFOcupacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncuestaFOcupacionServicio {

    @Autowired
    private FOcupacionEncuestaDao fOcupacionEncuestaDao;
    @Autowired
    private RegistroEncuestaFOcupacionDao registroEncuestaFOcupacionDao;

    public EncuestaFOcupacionServicio() {
    }

    public void addRegFOcupacionEncuesta(RegistroEncuestaFOcupacion regFOcupacion) {
        registroEncuestaFOcupacionDao.addRegFOcupacionEncuesta(regFOcupacion);
    }

    public void addFOcupacionEncuesta(FOcupacionEncuesta fOcupacionEncuesta) {
        fOcupacionEncuestaDao.addFOcupacionEncuesta(fOcupacionEncuesta);
    }

    public FOcupacionEncuestaDao getfOcupacionEncuestaDao() {
        return fOcupacionEncuestaDao;
    }

    public void setfOcupacionEncuestaDao(FOcupacionEncuestaDao fOcupacionEncuestaDao) {
        this.fOcupacionEncuestaDao = fOcupacionEncuestaDao;
    }

    public RegistroEncuestaFOcupacionDao getRegistroEncuestaFOcupacionDao() {
        return registroEncuestaFOcupacionDao;
    }

    public void setRegistroEncuestaFOcupacionDao(RegistroEncuestaFOcupacionDao registroEncuestaFOcupacionDao) {
        this.registroEncuestaFOcupacionDao = registroEncuestaFOcupacionDao;
    }
}
