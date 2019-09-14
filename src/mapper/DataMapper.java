package mapper;

import domain.DomainObject;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: CoffeeWeb
 * @description: Data Mapper
 * @author: DennyLee
 * @create: 2019-09-02 00:25
 **/
public abstract class DataMapper {
    public abstract boolean insert(DomainObject domainObject);

    public abstract boolean delete(DomainObject domainObject);

    public abstract boolean update(DomainObject domainObject);

    public static DataMapper getMapper(Object obj) {

        DataMapper dm = null;
        try {
            dm = (DataMapper) Class.forName("mapper." + obj.getClass().getSimpleName() + "Mapper").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dm;


    }

}
