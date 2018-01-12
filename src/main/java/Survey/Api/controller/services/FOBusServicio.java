package Survey.Api.controller.services;

import Survey.Api.model.dao.FOBusDao;
import Survey.Api.model.dao.RegistroFOBusDao;
import Survey.Api.model.entity.db.FOBus;
import Survey.Api.model.entity.db.RegistroFOBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FOBusServicio {

    @Autowired
    FOBusDao foBusDao;

    @Autowired
    RegistroFOBusDao registroFOBusDao;


    public FOBusServicio() {
    }


    public void addFoBus(FOBus fr_bus) {
        foBusDao.addFOBus(fr_bus);
    }

    public void addFOBusRegistro(RegistroFOBus registroFOBus) {
        registroFOBusDao.addRegistroFOBus(registroFOBus);
    }
}
