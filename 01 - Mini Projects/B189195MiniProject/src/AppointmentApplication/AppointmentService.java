package AppointmentApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

//10-randevu ile ilgili işlemler
public class AppointmentService {

    public Scanner inp=new Scanner(System.in);

    //11-oluşan randevuları listede tutalım, çünkü daha sonra görüntüleyeceğiz
    public List<Appointment> appointments=new ArrayList<>();

    //12-randevu oluşturma
    public void createAppointment(DoctorService doctorService){
        //13-dr listesini gösterelim
        doctorService.printDoctors();
        System.out.println("Randevu almak istediğiniz doktoru seçiniz (no): ");
        int selectDr=inp.nextInt();//1
        inp.nextLine();

        Doctor doctor=doctorService.findDoctorById(selectDr);
        if (doctor!=null){
            //14-tarih seçme : takvimde randevu için müsait tarih var mı
            if (doctor.getDates().isEmpty()){
                System.out.println(doctor.getName()+" un bu hafta tüm randevuları dolmuştur, daha sonra tekrar deneyiniz.");
            }else {
                //randevu oluşturmaya devam
                System.out.println("Lütfen ismini giriniz: ");
                String name=inp.nextLine();
                System.out.println("Sayın "+name+" randevu alabileceğiniz tarihler : ");
                for (int i=1;i<=doctor.getDates().size();i++){
                    System.out.println(i+" - "+doctor.getDates().get(i-1));//1-2023-09-26--index:0
                                                                           //2-2023-09-27--index:1
                }
                System.out.println("Randevu almak istediğiniz tarihin numarasını giriniz : ");
                int dateNo=inp.nextInt();
                inp.nextLine();
                //15-geçerli bir tarih no girildi mi
                if (dateNo>0 && dateNo<=doctor.getDates().size()){
                    //randevu oluşturabilir
                    Appointment appointment=new Appointment(name,doctor,doctor.getDates().get(dateNo-1));
                    //randevu tarihinin doktorun takviminden silinmesi gerekir
                    doctor.getDates().remove(dateNo-1);
                    //randevuyu kaydedelim
                    this.appointments.add(appointment);
                    System.out.println("Sayın "+name+" randevunuz başarılı bir şekilde oluşturuldu.");
                    System.out.println("Randevu no : "+appointment.getAppointmentNo()+" ile randevu bilgilerinizi görüntüleyebilirsiniz. ");
                }else {
                    System.out.println("Hatalı giriş, tekrar deneyiniz!");
                }
            }
        }else {
            System.out.println("Doktor bulunamadı, tekrar deneyiniz.");
        }
    }

    //16-nosu verilen randevuyu görüntüleme
    public void displayAppointment(){
        boolean isFound=false;
        System.out.println("Randevu no giriniz : ");
        int no=inp.nextInt();
        inp.nextLine();
        for (Appointment app:this.appointments){
            if (app.getAppointmentNo()==no){
                isFound=true;
                System.out.println("---------------------------------------------");
                System.out.println(no+" 'lu Randevu Bilgileri");
                System.out.println("Hasta adı : "+app.getName());
                System.out.println("Branş : "+app.getDoctor().getBranch());
                System.out.println("Doktor : "+app.getDoctor().getName());
                System.out.println("Randevu tarihi : "+app.getDate());
                System.out.println("---------------------------------------------");
                break;
            }
        }
        if (!isFound){
            System.out.println("Randevu bulunamadı...");
        }

    }




}
