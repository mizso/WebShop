package order;

import product.Book;
import product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<OrderItem> orderItems;

    public Order() {
        orderItems = new ArrayList<OrderItem>();
    }

    public static void main(final String args[]) {
        Book book = new Book(1, new BigDecimal("10.2"), "Sigmund Freud", "The Interpretation of Dreams");

        Order order = new Order();
        order.AddItemToBasket(book, 2);
        System.out.println("Order: " + order);
        System.out.println("Total :" + order.getTotalCost());
    }

    public void AddItemToBasket(Product product){
        orderItems.add(new OrderItem(product));
    }

    public void AddItemToBasket(Product product, int quantity){
        orderItems.add(new OrderItem(product, quantity));
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getTotalCost() {
        BigDecimal total = new BigDecimal(0);

        for (OrderItem orderItem : orderItems) {
            total = total.add(orderItem.getTotalPrice());
        }
        return total;
    }

    private BigDecimal round(final BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer();
        sb.append("Order [orderId=" + orderId + "] ");
        for (OrderItem orderItem : orderItems) {
            sb.append("\n");
            sb.append("item: " + orderItem.getItem().getProductId());
            sb.append(" quantity : " + orderItem.getQuantity());
            sb.append(" price: " + orderItem.getItem().getPrice());
            sb.append(" total price: " + orderItem.getTotalPrice());
        }

        sb.append("\n");
        sb.append("total price: " + this.getTotalCost());

        return sb.toString();
    }
}