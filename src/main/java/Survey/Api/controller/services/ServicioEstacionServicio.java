package Survey.Api.controller.services;

import Survey.Api.model.dao.EstacionDao;
import Survey.Api.model.dao.ServicioDao;
import Survey.Api.model.dao.ServicioEstacionDao;
import Survey.Api.model.entity.db.ServicioEstacion;
import Survey.Api.model.entity.db.ServicioTs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEstacionServicio {

    @Autowired
    private ServicioDao servicioDao;

    @Autowired
    private EstacionDao estacionDao;

    @Autowired
    private ServicioEstacionDao servicioEstacionDao;


    public ServicioEstacionServicio() {
    }

    public ServicioDao getServicioDao() {
        return servicioDao;
    }

    public void setServicioDao(ServicioDao servicioDao) {
        this.servicioDao = servicioDao;
    }

    public EstacionDao getEstacionDao() {
        return estacionDao;
    }

    public void setEstacionDao(EstacionDao estacionDao) {
        this.estacionDao = estacionDao;
    }

    public ServicioEstacionDao getServicioEstacionDao() {
        return servicioEstacionDao;
    }

    public void setServicioEstacionDao(ServicioEstacionDao servicioEstacionDao) {
        this.servicioEstacionDao = servicioEstacionDao;
    }

    public List<ServicioTs> encontrarTodosLosServicios(){
       return servicioDao.encontrarTodosLosServicios();
    }

    public List<ServicioEstacion> encontrarEstacionesAsociadas(ServicioTs servicioTs) {
        return servicioEstacionDao.encontrarEstacionesAsociadas(servicioTs);
    }
}
