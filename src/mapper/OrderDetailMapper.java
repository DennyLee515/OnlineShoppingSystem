package mapper;

import domain.*;
import service.CategoryService;
import service.OrderService;
import service.ProductService;
import service.UserService;
import util.DBConnection;
import util.IdentityMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description: Data Mapper for Order detail
 * @author: DennyLee
 * @create: 2019-09-02 23:56
 **/
// TODO: implement in feature 2
public class OrderDetailMapper extends DataMapper{
    @Override
    public boolean insert(DomainObject domainObject){
        OrderDetail orderDetail = (OrderDetail)domainObject;
        String insertOrderDetail = "INSERT INTO public.order_detail " +
                "(order_id, product_id, product_amount, p_category_id) " +
                "VALUES (?,?,?,?)";
        int result = 0;
        try{
            PreparedStatement preparedStatement = DBConnection.prepare(insertOrderDetail);
            preparedStatement.setString(1,orderDetail.getOrder().getId());
            preparedStatement.setString(2,orderDetail.getProduct().getId());
            preparedStatement.setInt(3,orderDetail.getProductAmount());
            preparedStatement.setString(4,orderDetail.getProductCategory().getId());
            result = preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return result!=0;
    }

    @Override
    public boolean delete(DomainObject domainObject){
        return false;
    }

    @Override
    public boolean update(DomainObject domainObject) {
        return false;
    }

    public List<OrderDetail> findOrderDetailByOrderId(DomainObject domainObject){
        OrderDetail orderDetail = (OrderDetail) domainObject;
        String findOrderById = "SELECT * FROM public.order_detail WHERE order_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findOrderById);
            preparedStatement.setString(1, orderDetail.getOrder().getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<OrderDetail> result = new ArrayList<>();
            while (resultSet.next()) {
                OrderDetail orderDetail1 = new OrderDetail();

                Order order = new Order();
                order.setOrderId(resultSet.getString(1));
                orderDetail1.setOrder(new OrderService().findOrderById(order));

                Product product=  new Product();
                product.setProductId(resultSet.getString(2));
                orderDetail1.setProduct(new ProductService().findProductByID(product));

                orderDetail1.setProductAmount(resultSet.getInt(3));
                Category category = new Category();
                category.setCategoryId(resultSet.getString(4));
                orderDetail1.setProductCategory(new CategoryService().findCategroyById(category));

                result.add(orderDetail1);

            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
