package product;

import java.math.BigDecimal;

public class Product {
    final protected int productId;
    protected BigDecimal price;

    private Product(ProductBuilder builder) {
        this.productId = builder.productId;
        this.price = builder.price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

//    private BigDecimal round(final BigDecimal value) {
//        return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
//    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        return price != null ? price.equals(product.price) : product.price == null;

    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public static class ProductBuilder{
        final protected int productId;
        protected BigDecimal price;

        public ProductBuilder(final int productId, BigDecimal price) {
            this.productId = productId;
            this.price = price;
        }

        public ProductBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
