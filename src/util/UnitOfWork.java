package util;

import domain.DomainObject;
import mapper.DataMapper;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class UnitOfWork {
    private static ThreadLocal current = new ThreadLocal();

    private List<DomainObject> newObjects = new ArrayList<DomainObject>();
    private List<DomainObject> dirtyObjects = new ArrayList<DomainObject>();
    private List<DomainObject> deleteObjects = new ArrayList<DomainObject>();

    public static void newCurrent() {
        setCurrent(new UnitOfWork());
    }

    public static UnitOfWork getCurrent() {
        return (UnitOfWork) current.get();
    }

    public static void setCurrent(UnitOfWork uow) {
        current.set(uow);
    }

    public boolean checkExist(DomainObject domainObject) {
        if (dirtyObjects.contains(domainObject))
            return true;
        if (deleteObjects.contains(domainObject))
            return true;
        if (newObjects.contains(domainObject)) {
            return true;
        }
        return false;
    }

    public void registerNew(DomainObject obj) {
//        Assert.assertNotNull("id is null", obj.getId());
//        Assert.assertTrue("obj is dirty", !dirtyObjects.contains(obj));
//        Assert.assertTrue("obj is deleted", !deleteObjects.contains(obj));
//        Assert.assertTrue("obj is dirty", !dirtyObjects.contains(obj));
//        newObjects.add(obj);
        if(!checkExist(obj)) {
            newObjects.add(obj);
        }

    }


    public void registerDirty(DomainObject obj) {
//        Assert.assertNotNull("id is null", obj.getId());
//        Assert.assertTrue("obj is deleted", !deleteObjects.contains(obj));
//        if (!dirtyObjects.contains(obj) && !newObjects.contains(obj)) {
//            dirtyObjects.add(obj);
//        }
        if(!checkExist(obj)) {
            dirtyObjects.add(obj);
        }
    }

    public void registerDelete(DomainObject obj) {
//        Assert.assertNotNull("id is null", obj.getId());
//        if (newObjects.remove(obj)) return;
//        dirtyObjects.remove(obj);
//        if (!deleteObjects.contains(obj)) {
//            deleteObjects.add(obj);
//        }
        if(!checkExist(obj)) {
            deleteObjects.add(obj);
        }
    }


    public void registerClean(DomainObject obj) {
        Assert.assertNotNull("id is null", obj.getId());

    }


    public boolean commit() {
        boolean result;
        try {
            for (DomainObject obj : newObjects) {
                result = DataMapper.getMapper(obj).insert(obj);
                if (!result){
                    return result;
                }
            }
            for (DomainObject obj : dirtyObjects) {
                result = DataMapper.getMapper(obj).update(obj);
                if (!result){
                    return result;
                }
            }
            for (DomainObject obj : deleteObjects) {
                result = DataMapper.getMapper(obj).delete(obj);
                if (!result){
                    return result;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
