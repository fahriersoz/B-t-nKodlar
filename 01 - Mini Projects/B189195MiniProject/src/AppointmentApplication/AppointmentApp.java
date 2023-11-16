package AppointmentApplication;

import java.util.Scanner;

/*
Proje: Randevu oluşturma uygulaması geliştiriniz.

       1-Ana menüde kullanıcıya randevu alma veya görüntülemek için iki seçenek sunulur.
       2-Randevu alma/oluşturma
            -Kullanıcıya mevcut doktorlar ve uygun oldukları tarihler gösterilir.
            -Kullanıcıdan no ile doktor seçmesi istenir.
            -Seçilen doktorun takvimi gösterilir.
            -Randevu alınmak istenen tarihin seçilmesi istenir.
            -en yakın 7 günlük takvim dolmuşsa daha sonra denenmesi istenir.
            -Geçerli bir tarih seçilmişse randevu oluşturulur ve bu tarih doktorun takviminden silinir.

       3-Randevu görüntüleme:
            -Kullanıcıya randevu no sorulur,
             randevu listesinde girilen no ile eşleşen randevu bilgileri yazdırılır.

       4-Doktor:
            -id, isim, branş, takvim
            -takvim: sistemin kullanıldığı günden 1 gün sonra başlamak üzere
                     7 günlük uygun randevu tarihleri

       5-Randevu:
            -id : otomatik üretilsin
            -hasta adı,Doktor,randevu tarihi

       6-Sistemde doktorlar kayıtlı olsun.
ÖDEV:
i- randevu iptal işlemi(randevu no)
ii-randevu tarihi güncellenebilir
iii-branş ile filtreleme yaptıktan sonra Dr seçimi yapılsın

 */
public class AppointmentApp {
    public static void main(String[] args) {
         start();
    }
    //1-ana menüyü oluştur
    //2-doctor,appointment classlarını oluşturalım
    private static void start(){
        Scanner inp=new Scanner(System.in);
        AppointmentService appointmentService=new AppointmentService();
        DoctorService doctorService=new DoctorService();
        int select;
        do {
            System.out.println("Merhaba, randevu sistemine hoşgeldiniz:)");
            System.out.println("1-Randevu alma");
            System.out.println("2-Randevu görüntüleme");
            System.out.println("0-ÇIKIŞ");
            System.out.print("Seçiminiz : ");
            select= inp.nextInt();
            switch (select){
                case 1:
                    appointmentService.createAppointment(doctorService);
                    break;
                case 2:
                    appointmentService.displayAppointment();
                    break;
                case 0:
                    System.out.println("Sağlıklı günler dileriz...");
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    break;
            }

        }while (select!=0);

    }










}
