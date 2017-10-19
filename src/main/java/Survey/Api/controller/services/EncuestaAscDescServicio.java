package Survey.Api.controller.services;

import Survey.Api.model.dao.CuadroEncuestaDao;
import Survey.Api.model.dao.RegistroEncuestaAscDescDao;
import Survey.Api.model.entity.CuadroEncuesta;
import Survey.Api.model.entity.RegistroEncuestaAscDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncuestaAscDescServicio {

    @Autowired
    private CuadroEncuestaDao cuadroEncuestaDao;
    @Autowired
    private RegistroEncuestaAscDescDao registroEncuestaAscDescDao;

    public EncuestaAscDescServicio() {
    }

    public void addRegistroEncuestaAscDesc(RegistroEncuestaAscDesc registro) {
        registroEncuestaAscDescDao.addRegistroEncuestaAscDesc(registro);
    }

    public void addCuadroEncuesta(CuadroEncuesta cuadroEncuesta) {
        cuadroEncuestaDao.addCuadroEncuesta(cuadroEncuesta);
    }

    public CuadroEncuestaDao getCuadroEncuestaDao() {
        return cuadroEncuestaDao;
    }

    public void setCuadroEncuestaDao(CuadroEncuestaDao cuadroEncuestaDao) {
        this.cuadroEncuestaDao = cuadroEncuestaDao;
    }

    public RegistroEncuestaAscDescDao getRegistroEncuestaAscDescDao() {
        return registroEncuestaAscDescDao;
    }

    public void setRegistroEncuestaAscDescDao(RegistroEncuestaAscDescDao registroEncuestaAscDescDao) {
        this.registroEncuestaAscDescDao = registroEncuestaAscDescDao;
    }
}
