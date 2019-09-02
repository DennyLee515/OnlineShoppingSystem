package Mapper;

import Domain.DomainObject;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-02 00:25
 **/
public abstract class DataMapper {
    public abstract boolean insert(DomainObject domainObject);
    
    public abstract boolean delete(DomainObject domainObject) throws Exception;
    
    public abstract boolean update(DomainObject domainObject) throws Exception;
}
