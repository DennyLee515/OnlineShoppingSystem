//package Util;
//
//import Domain.DomainObject;
//import Mapper.DataMapper;
//
//
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.Assert;
//
//public class UnitOfWork {
//    private static ThreadLocal current = new ThreadLocal();
//
//    private List<DomainObject> newObjects = new ArrayList<DomainObject>();
//    private List<DomainObject> dirtyObjects = new ArrayList<DomainObject>();
//    private List<DomainObject> deleteObjects = new ArrayList<DomainObject>();
//
//    public static void newCurrent(){
//        setCurrent(new UnitOfWork());
//    }
//
//    public static ThreadLocal getCurrent() {
//        return current;
//    }
//
//    public static void setCurrent(UnitOfWork uow) {
//        current.set(uow);
//    }
//
//    public void registerNew(DomainObject obj){
//        Assert.checkNonNull(obj.getId(), "id is null");
//        Assert.assertNotNull("id is null",obj.getId());
//        Assert.check(!dirtyObjects.contains(obj), "obj is dirty");
//        Assert.check(!deleteObjects.contains(obj), "obj is deleted");
//        Assert.check(!newObjects.contains(obj), "obj is new");
//        newObjects.add(obj);
//
//    }
//
//
//    public void registerDirty(DomainObject obj){
//        Assert.checkNonNull(obj.getId(), "id is null");
//        Assert.check(!deleteObjects.contains(obj), "obj is deleted");
//        if(!dirtyObjects.contains(obj) && !newObjects.contains(obj)){
//            dirtyObjects.add(obj);
//        }
//
//    }
//
//    public void registerDelete(DomainObject obj){
//        Assert.checkNonNull(obj.getId(), "id is null");
//        if (newObjects.remove(obj)) return;
//        dirtyObjects.remove(obj);
//        if(!deleteObjects.contains(obj)){
//            deleteObjects.add(obj);
//        }
//
//    }
//
//
//    public void registerClean(DomainObject obj){
//        Assert.checkNonNull(obj.getId(), "id is null");
//
//        }
//
//
//
//    public void commit() throws Exception {
//
//        for(DomainObject obj : newObjects){
//
//            DataMapper.getMapper(obj.getClass()).insert(obj);
//        }
//        for(DomainObject obj : dirtyObjects){
//            DataMapper.getMapper(obj.getClass()).update(obj);
//        }
//        for(DomainObject obj : deleteObjects){
//            DataMapper.getMapper(obj.getClass()).delete(obj);
//        }
//
//    }
//
//
//}
