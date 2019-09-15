package servlet;

import domain.Category;
import domain.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * handle requests to manage products by create, delete and edit
 */
public class AdminManageProductCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        //get parameters
        String method = request.getParameter("method");
        String productId;
        Product product;
        ProductService productService;
        CategoryService categoryService;
        List<Category> categories;

        switch (method) {
            //create new product
            case "create":
                categoryService = new CategoryService();
                categories = categoryService.getAllCategories();

                request.setAttribute("categories", categories);
                forward("/jsp/admin/newProduct.jsp");
                break;
            //delete a product
            case "delete":
                productId = request.getParameter("product");
                product = new Product();
                product.setProductId(productId);
                productService = new ProductService();
                boolean result = productService.deleteProduct(product);
                if (result) {
                    redirect("frontservlet?command=AdminProduct");
                } else {
                    request.setAttribute("errMsg", "Delete product failed");
                    forward("/jsp/error.jsp");
                }
                break;
            //edit product
            case "edit":
                productId = request.getParameter("product");
                product = new Product();
                product.setProductId(productId);
                productService = new ProductService();
                product = productService.findProductByID(product);

                categoryService = new CategoryService();
                categories = categoryService.getAllCategories();

                request.setAttribute("categories", categories);
                request.setAttribute("product", product);
                forward("/jsp/admin/editProduct.jsp");
                break;

            default:
                System.out.println("Wrong product manage method input");
        }
    }
}
