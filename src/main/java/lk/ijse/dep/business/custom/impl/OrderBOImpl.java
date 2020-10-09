package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.OrderBO;
import lk.ijse.dep.dao.custom.*;
import lk.ijse.dep.entity.CustomEntity;
import lk.ijse.dep.entity.Item;
import lk.ijse.dep.entity.Order;
import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.util.OrderDetailTM;
import lk.ijse.dep.util.OrderTM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class OrderBOImpl implements OrderBO {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderDetailDAO orderDetailDAO;
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private QueryDAO queryDAO;
    @Autowired
    private CustomerDAO customerDAO;

    public void placeOrder(OrderTM order, List<OrderDetailTM> orderDetails) throws Exception {

        orderDAO.save(new Order(order.getOrderId(), order.getOrderDate(), customerDAO.find(order.getCustomerId())));
        for (OrderDetailTM orderDetail : orderDetails) {
            orderDetailDAO.save(new OrderDetail(order.getOrderId(), orderDetail.getItemCode(), orderDetail.getQty(), BigDecimal.valueOf(orderDetail.getUnitPrice())));
            Object i = itemDAO.find(orderDetail.getItemCode());
            Item item = (Item) i;
            item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
            itemDAO.update(item);
        }

    }

    @Transactional(readOnly = true)
    public String getNewOrderId() throws Exception {
        String lastOrderId = orderDAO.getLastOrderId();

        if (lastOrderId == null) {
            return "OD001";
        } else {
            int maxId = Integer.parseInt(lastOrderId.replace("OD", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "OD00" + maxId;
            } else if (maxId < 100) {
                id = "OD0" + maxId;
            } else {
                id = "OD" + maxId;
            }
            return id;
        }
    }

    public List<OrderTM> searchOrder() throws Exception {

        List<CustomEntity> searchOrders = queryDAO.searchOrder();
        List<OrderTM> allOrders = new ArrayList<>();
        for (CustomEntity searchOrder : searchOrders) {
            allOrders.add(new OrderTM(searchOrder.getOrderId(), searchOrder.getOrderDate(),
                    searchOrder.getCustomerName()
                    , searchOrder.getCustomerId(), searchOrder.getTotal()));
        }
        return allOrders;

    }
}
