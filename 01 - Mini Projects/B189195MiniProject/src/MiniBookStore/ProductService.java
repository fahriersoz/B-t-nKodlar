package MiniBookStore;
//2-product ile yapılacak işlemler için bir standart
public interface ProductService {

     void processMenu();

     void listProducts();

     void addProduct();

     void deleteProduct();

     void filterProducts(String filter);

}
