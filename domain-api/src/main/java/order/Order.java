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
        Book book = new Book.BookBuilder(1, new BigDecimal("10.2")).
                withAuthor("Sigmund Freud").
                withTitle("The Interpretation of Dreams").build();
        Book secondBook = new Book.BookBuilder(2, new BigDecimal("20.3")).
                withAuthor("J. K. Rowling").
                withTitle("Harry Potter and the Philosopher's Stone").build();

        Order order = new Order();
        order.AddItemToBasket(book, 2);
        order.AddItemToBasket(secondBook);
        System.out.println("Order: " + order);
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
            sb.append(orderItem);
        }
        sb.append("\n");
        sb.append("Total price: " + this.getTotalCost());

        return sb.toString();
    }
}