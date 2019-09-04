package Mapper;

import Domain.DomainObject;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-02 00:25
 **/
public abstract class DataMapper {
    public abstract boolean insert(DomainObject domainObject) throws Exception;
    
    public abstract boolean delete(DomainObject domainObject) throws Exception;
    
    public abstract boolean update(DomainObject domainObject) throws Exception;

    public static DataMapper getMapper(Class obj) throws Exception{

        DataMapper dm = (DataMapper) Class.forName(obj.getClass().getSimpleName()+"Mapper").getDeclaredConstructor().newInstance();
        return dm;


    }



}
