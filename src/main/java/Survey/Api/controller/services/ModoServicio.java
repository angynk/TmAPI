package Survey.Api.controller.services;

import Survey.Api.model.dao.ModoDao;
import Survey.Api.model.entity.db.Modo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModoServicio {

    @Autowired
    private ModoDao modoDao;

    public ModoServicio() {
    }

    public List<Modo> getModoAll() {
        return modoDao.getModoAll();
    }
}
