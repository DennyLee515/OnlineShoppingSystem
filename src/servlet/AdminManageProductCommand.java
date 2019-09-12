package servlet;

import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminManageProductCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        String method = request.getParameter("method");
        String productId;
        Product product;
        ProductService productService;

        switch (method) {
            case "create":
                forward("/jsp/admin/newProduct.jsp");
                break;
            case "delete":
                productId = request.getParameter("product");
                product = new Product();
                product.setProductId(productId);
                productService = new ProductService();
                boolean result = productService.deleteProduct(product);
                if (result){
                    redirect("frontservlet?command=AdminProduct");
                }else{
                    //todo:redirect to error page
                    System.out.println("Delete product failed");
                }
                break;
            case "edit":
                productId = request.getParameter("product");
                product = new Product();
                product.setProductId(productId);
                productService = new ProductService();
                product = productService.findProductByID(product);
                request.setAttribute("product", product);
                forward("/jsp/admin/editProduct.jsp");
                break;
            default:
                System.out.println("Wrong product manage method input");
        }
    }
}
