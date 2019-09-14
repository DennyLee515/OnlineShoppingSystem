package service;

import domain.Category;
import domain.Product;
import mapper.ProductMapper;
import util.IdentityMap;

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

    public List<Product> findAvailableProduct() {
        List<Product> result = new ArrayList<>();
        return result;
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
        try {
            return productMapper.findProductsByCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertProduct(Product product) {
        try {
            return productMapper.insert(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduct(Product product) {
        try {
            return productMapper.delete(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProduct(Product product) {
        try {
            return productMapper.update(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRelation(Product product,Category category){
        try {
            return productMapper.deleteRelation(product,category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addRelation(Product product, Category category){
        try{
            return productMapper.addRelation(product,category);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
