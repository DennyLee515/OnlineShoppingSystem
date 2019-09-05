package Service;

import Domain.Product;
import Mapper.ProductMapper;

import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-06 00:15
 **/
public class ProductService {
    private ProductMapper productMapper;
    public ProductService(){
        productMapper = new ProductMapper();
    }
    public List<Product> getAll() {
        return productMapper.findAll();
    }
}
