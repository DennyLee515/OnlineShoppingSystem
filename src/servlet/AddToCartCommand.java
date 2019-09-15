package servlet;

import domain.CartDetail;
import domain.Category;
import domain.Product;
import domain.User;
import service.CartService;
import service.CategoryService;
import service.ProductService;
import service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description: add a product to cart
 * @author: DennyLee
 * @create: 2019-09-07 18:01
 **/
public class AddToCartCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        //get parameters
        String productId = request.getParameter("product");
        String categoryId = request.getParameter("category");
        int amount = Integer.parseInt(request.getParameter("amount"));

        //find product by id
        ProductService productService =new ProductService();
        Product product = new Product();
        product.setProductId(productId);
        product = productService.findProductByID(product);

        //find category by id
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

        //add to cart
        boolean result=cartService.AddToCart(user,product,amount,category);
        if (result){
            List<CartDetail> cartDetails = cartService.findCartDetailByUserId(user);
            request.setAttribute("cartDetails", cartDetails);
            forward("/jsp/user/cart.jsp");
        }else {
            request.setAttribute("errMsg","Add to cart failed.");
        }

    }
}
