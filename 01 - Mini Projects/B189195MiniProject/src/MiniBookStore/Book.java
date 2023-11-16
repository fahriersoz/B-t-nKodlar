package MiniBookStore;

//1-b-kitap öz:ürün öz+yazar adı, yayınevi,isbn no
public class Book extends Product{

    private String authorName;

    private String publisher;

    private String isbn;//unique

    //param const
    public Book(String name, String price, int stock,String authorName,String publisher,String isbn) {
        super(name, price, stock);
        this.authorName=authorName;
        this.publisher=publisher;
        this.isbn=isbn;
    }

    //getter-setter


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
