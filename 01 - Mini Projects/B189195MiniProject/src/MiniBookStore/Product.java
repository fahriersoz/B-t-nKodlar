package MiniBookStore;

//1-a-ürünlerin ortak öz:id,isim,birim fiyat,stok
public class Product {

    private static int counter=1;

    private int id;

    private String name;

    private String price;

    private int stock;

    //paramli const
    public Product(String name, String price, int stock) {
        this.id=counter++;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    //getter-setter


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
