package util;

import domain.Cart;
import domain.Product;
import domain.User;
import service.CartService;
import service.ProductService;
import service.UserService;

import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-02 21:25
 **/
public class test {
    public static void main(String args[]){
        try {
//        Date date = new Date();
//        User user = new User(2,"firstname","lastname","username","password",date,"email","address");
//        UserMapper userMapper = new UserMapper();
//        userMapper.insert(user);
//            Admin admin = new Admin("username0", "email0", "first1", "last1", "pw1", 1);
//            AdminMapper adminMapper = new AdminMapper();
//            adminMapper.insert(admin);
//            adminMapper.findAdminById(admin);

//            Product product = new Product("product2","info2",20.0,225,1);
//            ProductMapper productMapper = new ProductMapper();
//            productMapper.insert(product);

//            User user = new User("fistname","lastname","username","password",new Date(),"email",
//                    "adress");
            UserService userService = new UserService();
//            userService.insertUser(user);
            User user =new User();
            user.setUsername("username");
            user = userService.findUserByName(user);
            System.out.println(user);
            CartService cartService = new CartService();
            List<Cart> carts = cartService.findCartByUser(user);
            System.out.println(carts);


//            System.out.println(productMapper.findAll().get(0).getProductName());
//            ProductService productService = new ProductService();
//            Product product = productService.findProductByName("product2").get(0);

//            CartService cartService = new CartService();
//            cartService.AddToCart(user,product,1);
//            System.out.println(productService.getAll().get(0).getProductName());
//        AdminMapper adminMapper1 = new AdminMapper();
//        List<Admin> result = adminMapper1.findUserById(2);
//        System.out.println(result.get(0).getAdminLname());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
