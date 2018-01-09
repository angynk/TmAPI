package Survey.Api.model.dao;

import Survey.Api.model.entity.db.FOcupacionEncuesta;
import Survey.Api.model.entity.db.ODEncuesta;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Transactional
public class ODEncuestaDao {

    @Autowired
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addODEncuesta(ODEncuesta odEncuesta) {
        Serializable save = getSessionFactory().getCurrentSession().save(odEncuesta);

    }
}
