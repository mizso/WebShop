package order;

import product.Product;

import java.math.BigDecimal;

public class OrderItem {
    private Product item;
    private int quantity;

    public OrderItem(Product item) {
        this.item = item;
        quantity = 1;
    }

    public OrderItem(Product item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return item.getPrice().multiply(new BigDecimal(quantity));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n OrderItem [item=" + item + ", quantity=" + quantity + " total cost=" + getTotalPrice() +  "]";
    }
}
