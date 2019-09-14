package mapper;

import domain.DomainObject;
import domain.Order;

/**
 * @program: CoffeeWeb
 * @description: Data mapper for order
 * @author: DennyLee
 * @create: 2019-09-02 23:55
 **/

// TODO: Implement in feature 2
public class OrderMapper extends DataMapper {
    @Override
    public boolean insert(DomainObject domainObject) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(DomainObject domainObject){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(DomainObject domainObject) {
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Order findOrderById(DomainObject domainObject){
        return null;
    }
}
