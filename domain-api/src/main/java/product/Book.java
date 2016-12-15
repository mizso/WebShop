package product;

import java.math.BigDecimal;

public class Book extends Product{
    private String title;
    private String author;

    protected Book(BookBuilder builder) {
        super(builder);
        this.title = builder.title;
        this.author = builder.author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", author=" + author + ", title=" + title;
    }

    public static class BookBuilder extends ProductBuilder{
        private String title;
        private String author;

        public BookBuilder(int productId, BigDecimal price) {
            super(productId, price);
        }

        public BookBuilder withTitle(String title){
            this.title = title;
            return this;
        }
        public BookBuilder withAuthor(String author){
            this.author = author;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
}
