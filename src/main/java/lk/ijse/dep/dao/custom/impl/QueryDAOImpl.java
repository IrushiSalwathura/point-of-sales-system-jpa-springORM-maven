package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.custom.QueryDAO;
import lk.ijse.dep.entity.CustomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QueryDAOImpl implements QueryDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<CustomEntity> searchOrder() throws Exception {
        return (List<CustomEntity>) entityManager.createNativeQuery("SELECT O.id, O.date, C.id, C.name, SUM(OD.qty*od.unitPrice)\n" +
                "FROM `Order` O\n" +
                "INNER JOIN Customer C ON O.customerId = C.id\n" +
                "INNER JOIN orderdetail OD ON O.id = OD.orderId\n" +
                "GROUP BY O.id").getSingleResult();
    }
}
