package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudDAOImpl;
import lk.ijse.dep.dao.custom.OrderDAO;
import lk.ijse.dep.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl extends CrudDAOImpl<Order,String> implements OrderDAO {
    public String getLastOrderId() throws Exception {
        return (String) getSession().createNativeQuery("SELECT id FROM `Order` ORDER BY id DESC")
                .setMaxResults(1).list().get(0);
    }

}
