package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import mapper.OrderDetailMapper;

/**
 * @program: CoffeeWeb
 * @description: Order details of an order
 * @author: DennyLee
 * @create: 2019-09-01 23:28
 **/
public class OrderDetail extends DomainObject {
    //Order an order detail belongs to
    private Order order;
    //the product of the order detail item
    private Product product;
    //the product amount of the detail item
    private int productAmount;
    private Category productCategory;

    //constructor
    public OrderDetail() {
    }

    //constructor with order, product, product amount
    public OrderDetail(Order order, Product product, int productAmount, Category category) {
        this.order = order;
        this.product = product;
        this.productAmount = productAmount;
        this.productCategory = category;
    }

    //getter and setter methods
    public Order getOrder() {
//        if (this.order == null)
//            load();
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
//        if (this.product == null)
//            load();
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductAmount() {
//        if (this.productAmount == 0)
//            load();
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public Category getProductCategory() {
//        if (this.productCategory ==null)
//            load();
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

//    //use lazy load to reduce request
//    private void load() {
//        OrderDetailMapper orderDetailMapper = new OrderDetailMapper();
//        OrderDetail record = orderDetailMapper.findOrderDetailByOrderId(this);
//        if (this.order == null) {
//            this.order = record.getOrder();
//        }
//        if (this.product == null) {
//            this.product = record.getProduct();
//        }
//        if (this.productAmount == 0) {
//            this.productAmount = record.getProductAmount();
//        }
//        if (this.productCategory == null){
//            this.productCategory = record.getProductCategory();
//        }
//    }
}
