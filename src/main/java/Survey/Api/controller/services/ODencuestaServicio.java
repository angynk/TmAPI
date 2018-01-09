package Survey.Api.controller.services;

import Survey.Api.model.dao.ODEncuestaDao;
import Survey.Api.model.dao.ODRegistroDao;
import Survey.Api.model.dao.ODTransbordoDao;
import Survey.Api.model.entity.db.ODEncuesta;
import Survey.Api.model.entity.db.ODRegistro;
import Survey.Api.model.entity.db.ODTransbordo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ODencuestaServicio {

    @Autowired
    private ODEncuestaDao odEncuestaDao;

    @Autowired
    private ODRegistroDao odRegistroDao;

    @Autowired
    private ODTransbordoDao odTransbordoDao;


    public ODencuestaServicio() {
    }


    public void addODEncuesta(ODEncuesta od_encuesta) {
        odEncuestaDao.addODEncuesta(od_encuesta);
    }

    public void addODRegistro(ODRegistro odRegistro) {
        odRegistroDao.addODregistro(odRegistro);
    }

    public void addODTransbordo(ODTransbordo transbordo) {
        odTransbordoDao.addODtransbordo(transbordo);
    }
}
