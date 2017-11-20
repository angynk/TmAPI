package Survey.Api.controller.services;

import Survey.Api.model.dao.ADPuntoEncuestaDao;
import Survey.Api.model.dao.RegistroEncuestaAscDesPuntoDao;
import Survey.Api.model.entity.db.ADPuntoEncuesta;
import Survey.Api.model.entity.db.RegistroEncuestaADPunto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncuestaAscDescPuntoServicio {

    @Autowired
    private ADPuntoEncuestaDao adPuntoEncuestaDao;
    @Autowired
    private RegistroEncuestaAscDesPuntoDao registroEncuestaAscDesPuntoDao;

    public EncuestaAscDescPuntoServicio() {
    }

    public void addADRegPuntoEncuesta(RegistroEncuestaADPunto registroEncuestaADPunto) {
        registroEncuestaAscDesPuntoDao.addADRegPuntoEncuesta(registroEncuestaADPunto);
    }

    public void addADPuntoEncuesta(ADPuntoEncuesta cuadroEncuesta) {
        adPuntoEncuestaDao.addADPuntoEncuesta(cuadroEncuesta);
    }


}
