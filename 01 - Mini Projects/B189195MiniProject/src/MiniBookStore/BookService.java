package MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a:Kitaplarla yapılabilecek işlemler
public class BookService implements ProductService {

    public Scanner inp=new Scanner(System.in);

    //3-kitapları saklamak için list oluşturalım
    public List<Book> bookList=new ArrayList<>();

    //4-sistemde başlangıçta mevcut olan kitaplar olsun:test için
    public BookService(){
        Book book1=new Book("Fareler ve İnsanlar","150",15,"J.Steinbeck","Penguin","A111");
        Book book2=new Book("Suç ve Ceza","250",25,"Dostoyevski","Penguin","A222");
        Book book3=new Book("Sefiller","170",15,"V.Hugo","Dream","A333");
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }

    //5-işlem seçim menüsü
    @Override
    public void processMenu() {
        int choice;
        do {
            System.out.println("--------------------------------------------");
            System.out.println("1-Kitapları listele");
            System.out.println("2-Kitap ekle");
            System.out.println("3-Kitabı sil");
            System.out.println("4-Yayınevine göre filtrele");
            System.out.println("0-Geri Dön");
            System.out.println("Seçiminiz: ");
            choice=inp.nextInt();
            inp.nextLine();
            switch (choice){
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("Yayınevi :");
                    String publisher=inp.nextLine();
                    filterProducts(publisher);
                    break;
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz.");
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    break;
            }
        }while (choice!=0);



    }

    //6-kitapları formata listele
    @Override
    public void listProducts() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-3s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s | \n","ID","Kitap Adı","Yazar Adı","Yayınevi",
                "ISBN","Birim Fiyat","Stok");
        System.out.println("-----------------------------------------------------------------------------------");
        this.bookList.forEach(book -> System.out.printf("%-3s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s | \n",
                book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getIsbn(),
                book.getPrice()+" Lira",book.getStock()));
        System.out.println("-----------------------------------------------------------------------------------");

    }

    //7-yeni kitap girişi
    @Override
    public void addProduct() {
        System.out.println("ISBN : ");
        String isbn=inp.nextLine();
        //bu kitap daha önce sisteme girilmiş mi
        boolean isExists=false;
        for (Book book:this.bookList){
            if (book.getIsbn().equals(isbn)){
                System.out.println("Bu kitap sistemde kayıtlı, lütfen ürün güncelleme yapınız.");//stok güncelleme:ÖDEV
                isExists=true;
                break;
            }
        }
        if (!isExists){
            System.out.println("Kitap Adı :");
            String name=inp.nextLine();
            System.out.println("Yazar Adı :");
            String author=inp.nextLine();
            System.out.println("Yayınevi:");
            String publisher=inp.nextLine();
            System.out.println("Birim Fiyat :");
            String price=inp.nextLine();
            System.out.println("Stok : ");
            int stock= inp.nextInt();
            inp.nextLine();

            Book newBook=new Book(name,price,stock,author,publisher,isbn);
            this.bookList.add(newBook);
        }
        listProducts();
    }
 //8-kullanıcıdan alınan id ile silme işlemi
    @Override
    public void deleteProduct() {
        boolean isFound=false;
        System.out.println("Kitap id : ");
        int id= inp.nextInt();
        for (Book book:this.bookList){
            if (book.getId()==id){
                this.bookList.remove(book);
                System.out.println("Ürün silindi.");
                isFound=true;
                break;
            }
            else {
              isFound=false;
            }
        }
        if (!isFound){
            System.out.println("Ürün bulunamadı!");
        }

    }

    //9-yayınevine göre filtereleme
    @Override
    public void filterProducts(String filter) {
        int counter=0;
        for (Book book:this.bookList){
            if (book.getPublisher().equalsIgnoreCase(filter)){

                System.out.printf("%-3s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s | \n",
                        book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getIsbn(),
                        book.getPrice()+" Lira",book.getStock());
                counter++;
            }
        }
        if (counter==0){
            System.out.println("Eşleşen ürün bulunamadı!");
        }

    }
}
