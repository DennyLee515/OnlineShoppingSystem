package servlet;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminAddCategoryCommand extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {


    }



//    public void process() throws ServletException, IOException {
//        String id = request.getParameter("product");
//        int amount = Integer.valueOf(request.getParameter("amount"));
//        ProductService productService =new ProductService();
//        Product product = new Product();
//        product.setProductId(id);
//        product = productService.findProductByID(product);
//        CartService cartService = new CartService();
//
//        //TODO: update user by using session.
//        User user = new User();
//        user.setUsername("username");
//        UserService userService = new UserService();
//        user = userService.findUserByName(user);
//        cartService.AddToCart(user,product,amount);
//        List<Cart> carts = cartService.findCartByUser(user);
//        System.out.println(carts.toString());
//        request.setAttribute("carts", carts);
//        forward("/jsp/cart.jsp");
}
