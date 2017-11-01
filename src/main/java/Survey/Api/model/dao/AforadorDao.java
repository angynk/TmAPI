package Survey.Api.model.dao;

import Survey.Api.model.entity.db.Aforador;
import Survey.Api.model.entity.db.ServicioTs;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class AforadorDao {

    @Autowired
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Aforador encontrarAforadorPorUsuario(String usuario){
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Aforador.class);
      criteria.add(Restrictions.eq("usuario", usuario));
        return (Aforador) criteria.uniqueResult();
    }

    public void actualizarAforador(Aforador aforador){
        getSessionFactory().getCurrentSession().update(aforador);
    }


}
