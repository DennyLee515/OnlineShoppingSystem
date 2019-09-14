package util;

import domain.*;
import mapper.*;
import service.CartService;
import service.CategoryService;
import service.ProductService;
import service.UserService;

import java.util.Date;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-02 21:25
 **/
public class test {
    public static void main(String args[]) {
        try {
//        Date date = new Date();
//        User user = new User(2,"firstname","lastname","username","password",date,"email",
//        "address");
//        UserMapper userMapper = new UserMapper();
//        userMapper.insert(user);
//            Admin admin = new Admin("username0", "email0", "first1", "last1", "pw1", 1);
//            AdminMapper adminMapper = new AdminMapper();
//            adminMapper.insert(admin);
//            adminMapper.findAdminById(admin);

//            Product product = new Product("product2","info2",20.0,225,1);
//            ProductMapper productMapper = new ProductMapper();
//            productMapper.insert(product);

//            User user = new User("firstname","lastname","username","password",new Date(),
//                    "email1", "address1");
            UserService userService = new UserService();
//            user.setUsername("username");
//            userService.findUserByName(user);
//            userService.insertUser(user);

//            System.out.println(DataMapper.getMapper(user));
            User user =new User();
            user.setUsername("username");
            user = userService.findUserByName(user);
            Cart cart = new Cart(user);
            CartMapper cartMapper = new CartMapper();
            cartMapper.insert(cart);
//            Cart cart = new Cart(user);

            System.out.println(user.getId());
//            CartService cartService = new CartService();
//            cartService.insertCart(cart);
//            List<CartDetail> carts = cartService.findCartByUser(user);
//            System.out.println(carts);

//            Category category =new Category();
//            category.setCategoryId("d40a490e-c242-441a-8a44-e1b4550c15ca");
//
//            CategoryService categoryService = new CategoryService();
//            System.out.println(categoryService.findCategroyById(category));

//            Manager manager = new Manager("manager", "password", "email");
//            Clerk clerk = new Clerk("clerk", "password", "firstname", "lastname", new Date(),
//                    new Date());

//            StaffMapper staffMapper = new StaffMapper();
//            Staff staff = new Staff();
//            staff.setStaffId("b8026488-74c7-460e-bac1-de7de1b3e7fb");

//            staffMapper.insert(manager);
//            staffMapper.insert(clerk);

//            System.out.println(staffMapper.delete(staff));
//            System.out.println(productMapper.getAllCategories().get(0).getProductName());
//            ProductService productService = new ProductService();
//            Product product = productService.findProductByName("product2").get(0);

//            CartService cartService = new CartService();
//            cartService.AddToCart(user,product,1);
//            System.out.println(productService.getAll().get(0).getProductName());
//        AdminMapper adminMapper1 = new AdminMapper();
//        List<Admin> result = adminMapper1.findUserById(2);
//        System.out.println(result.get(0).getAdminLname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
