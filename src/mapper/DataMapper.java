package mapper;

import domain.DomainObject;

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

        DataMapper dm = (DataMapper) Class.forName(obj.getClass().getSimpleName()+ "mapper").getDeclaredConstructor().newInstance();
        return dm;


    }

}
