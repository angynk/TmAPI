package Survey.Api.controller.services;

import Survey.Api.model.dao.AforadorDao;
import Survey.Api.model.entity.db.Aforador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoginServicio {

    @Autowired
    private AforadorDao aforadorDao;

    public LoginServicio() {
    }

    public boolean iniciarSesion(String usuario,String contrasena){
        Aforador aforador = aforadorDao.encontrarAforadorPorUsuario(usuario);
        if(aforador!=null){
            if(aforador.getContrasena().equals(contrasena)){
                aforador.setUltimoIngreso(new Date());
                actualizarAforador(aforador);
                return true;
            }
        }
        return false;
    }

    public void actualizarAforador(Aforador aforador){
        aforadorDao.actualizarAforador(aforador);
    }
}
