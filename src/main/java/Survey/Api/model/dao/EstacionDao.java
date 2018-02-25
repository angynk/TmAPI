package Survey.Api.model.dao;

import Survey.Api.model.entity.db.Estacion;
import Survey.Api.model.entity.db.ServicioEstacion;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EstacionDao {

    @Autowired
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Estacion> encontrarTodo(String modo) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Estacion.class);
        if(modo!=""){
            criteria.add(Restrictions.eq("modo", modo));
        }
        criteria.addOrder(Order.asc("nombre"));
        return  criteria.list();
    }
}
