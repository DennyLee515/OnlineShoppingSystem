package service;

import domain.Category;
import domain.Product;
import mapper.ProductMapper;
import util.IdentityMap;
import util.UnitOfWork;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-06 00:15
 **/
public class ProductService {
    private ProductMapper productMapper;

    public ProductService() {
        productMapper = new ProductMapper();
    }

    public List<Product> getAll() {
        return productMapper.getAllProducts();
    }

    public List<Product> getAllAvailableProducts() {
        return productMapper.getAllAvailableProducts();
    }

    public Product findProductByID(Product product) {
        IdentityMap<Product> identityMap = IdentityMap.getInstance(product);
        Product productFinded = identityMap.get(product.getId());
        if (productFinded != null) {
            return productFinded;
        }
        return productMapper.findProductById(product);
    }

    public Product findProductByName(Product product) {
        return productMapper.findProductByName(product);
    }

    public List<Product> findProductByCategory(Category category) {
        return productMapper.findProductsByCategory(category);
    }

    public boolean insertProduct(Product product) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(product);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean deleteProduct(Product product) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDelete(product);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean updateProduct(Product product) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(product);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean deleteRelation(Product product, Category category) {
        try {
            return productMapper.deleteRelation(product, category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addRelation(Product product, Category category) {
        try {
            return productMapper.addRelation(product, category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAllRelations(Product product) {
        return productMapper.deleteAllRelationsByProduct(product);
    }

}
