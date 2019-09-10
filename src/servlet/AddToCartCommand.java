package servlet;

import domain.Cart;
import domain.Product;
import domain.User;
import mapper.UserMapper;
import service.CartService;
import service.ProductService;
import service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-07 18:01
 **/
public class AddToCartCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        String id = request.getParameter("product");
        int amount = Integer.valueOf(request.getParameter("amount"));
        ProductService productService =new ProductService();
        Product product = new Product();
        product.setProductId(id);
        product = productService.findProductByID(product);
        CartService cartService = new CartService();

        //TODO: update user by using session.
        User user = new User();
        user.setUsername("username");
        UserService userService = new UserService();
        user = userService.findUserByName(user);
        cartService.AddToCart(user,product,amount);
        List<Cart> carts = cartService.findCartByUser(user);
        System.out.println(carts.toString());
        request.setAttribute("carts", carts);
        forward("/jsp/cart.jsp");
    }
}
