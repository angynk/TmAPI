package Survey.Api.controller.services;

import Survey.Api.model.dao.CoDespachosEncuestaDao;
import Survey.Api.model.dao.RegistroConteoDesDao;
import Survey.Api.model.entity.db.CoDespachosEncuesta;
import Survey.Api.model.entity.db.RegistroConteoDespacho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConteoDespachosServicio {

    @Autowired
    private CoDespachosEncuestaDao coDespachosEncuestaDao;

    @Autowired
    private RegistroConteoDesDao registroConteoDesDao;


    public ConteoDespachosServicio() {
    }


    public void addConteoDespachos(CoDespachosEncuesta co_despacho) {
        coDespachosEncuestaDao.addConteoDespacho(co_despacho);
    }

    public void addRegistroConteoDespachos(RegistroConteoDespacho registro) {
        registroConteoDesDao.addRegistroConteoDespacho(registro);
    }
}
