package Survey.Api.model.dao;

import Survey.Api.model.entity.db.ServicioTs;
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
public class ServicioDao {

    @Autowired
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<ServicioTs> encontrarTodosLosServicios(String modo){
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(ServicioTs.class);
        if(modo!=""){
            criteria.add(Restrictions.eq("tipo", modo));
        }
        criteria.addOrder(Order.asc("nombre"));
        return  criteria.list();
    }

}
