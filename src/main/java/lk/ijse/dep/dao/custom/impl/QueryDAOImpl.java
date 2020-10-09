package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.custom.QueryDAO;
import lk.ijse.dep.entity.CustomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class QueryDAOImpl implements QueryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<CustomEntity> searchOrder() throws Exception {
        return (List<CustomEntity>) getSession().createNativeQuery("SELECT O.id, O.date, C.id, C.name, SUM(OD.qty*od.unitPrice)\n" +
                "FROM `Order` O\n" +
                "INNER JOIN Customer C ON O.customerId = C.id\n" +
                "INNER JOIN orderdetail OD ON O.id = OD.orderId\n" +
                "GROUP BY O.id").uniqueResult();
    }
}
