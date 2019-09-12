package servlet;

import domain.Cart;
import domain.Category;
import domain.Product;
import domain.User;
import mapper.UserMapper;
import service.CartService;
import service.CategoryService;
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
        String productId = request.getParameter("product");
        String categoryId = request.getParameter("category");
        int amount = Integer.parseInt(request.getParameter("amount"));

        ProductService productService =new ProductService();
        Product product = new Product();
        product.setProductId(productId);
        product = productService.findProductByID(product);

        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        category.setCategoryId(categoryId);
        category = categoryService.findCategroyById(category);

        CartService cartService = new CartService();
        //TODO: update user by using session.
        User user = new User();
        user.setUsername("username");
        UserService userService = new UserService();
        user = userService.findUserByName(user);
        cartService.AddToCart(user,product,amount,category);
        List<Cart> carts = cartService.findCartByUser(user);
        request.setAttribute("carts", carts);
        forward("/jsp/user/cart.jsp");
    }
}
