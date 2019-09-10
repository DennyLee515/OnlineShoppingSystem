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
        return productMapper.findAll();
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

    public List<Product> findProductByName(String name) {
        return productMapper.findProductByName(name);
    }

    public List<Product> findProductByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        return result;
    }

    public boolean insertProduct() {
        return false;
    }

    public boolean deleteProduct() {
        return false;
    }

    public boolean UpdateProduct() {
        return false;
    }

}
