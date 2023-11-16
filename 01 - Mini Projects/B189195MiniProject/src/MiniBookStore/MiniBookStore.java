package MiniBookStore;

/*
Proje: Mini Book Store
        Online bir kitap market için ürün yönetim uygulaması yapınız.
        Kitap markette kitap ve defter satışı olacak, ancak ileride yeni ürün çeşidi eklenebilir olmalı.

        Kitap özellikleri: id, isim, birim fiyat, stok, yazar adı, yayınevi,isbn no
        Defter özellikleri: id, isim, birim fiyat, stok, marka, yaprak sayısı,ürün kodu

        Kullanıcı ilgili kategorideki ürünleri listeleyebilmeli
        Kullanıcı kategoriye göre ürün ekleyebilmeli,ürün mevcutsa uyarı verilmeli
        Kullanıcı ürünleri benzersiz numaralarına(id) göre silebilmeli.
        Kullanıcı ürünleri marka(defter)  veya yayınevine(kitap) göre filtreleyip listeleyebilmeli.
        C:create
        R:read
        U:update
        D:delete
 */


import java.util.Scanner;

public class MiniBookStore {
    public static void main(String[] args) {

        start();

    }

    //1-product,book,notebook classlarını oluşturalım
    //2-book,notebook için service classı oluşturma
    private static void start() {
        Scanner inp=new Scanner(System.in);
        int select;
        //service oluşturalım.
        ProductService bookService=new BookService();
        ProductService notebookService=new NotebookService();

        //10-kategori menüsü
        do {
            System.out.println("--- Mini Book Store ---");
            System.out.println("Ürün Yönetim Paneli");
            System.out.println("1-Kitaplar");
            System.out.println("2-Defterler");
            System.out.println("0-ÇIKIŞ");
            System.out.println("Seçiminiz : ");
            select=inp.nextInt();
            inp.nextLine();

            ProductService service=select==1 ? bookService : notebookService;

            switch (select){
                case 1: case 2:
                    service.processMenu();
                    break;
                //case 2:
                   // bookService.processMenu();
                case 0:
                    System.out.println("İyi günler...");
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    break;
            }

        }while (select!=0);




    }

}
