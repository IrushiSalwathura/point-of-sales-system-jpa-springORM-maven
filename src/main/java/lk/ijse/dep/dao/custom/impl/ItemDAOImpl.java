package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudDAOImpl;
import lk.ijse.dep.dao.custom.ItemDAO;
import lk.ijse.dep.entity.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl extends CrudDAOImpl<Item,String> implements ItemDAO {
    public String getLastItemCode() throws Exception {
        return (String) getSession().createNativeQuery("SELECT code FROM Item ORDER BY code DESC ")
                .setMaxResults(1).list().get(0);
    }
}
