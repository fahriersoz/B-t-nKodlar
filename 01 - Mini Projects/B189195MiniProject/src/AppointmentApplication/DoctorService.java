package AppointmentApplication;

import java.util.ArrayList;
import java.util.List;

//6-doktorlar sistemde kayıtlı olsun ve listelenebilsin
public class DoctorService {

    public List<Doctor> doctorList=new ArrayList<>();

    //7-service objesi oluşunca listede doktorlar olsun


    public DoctorService() {
        Doctor doctor1=new Doctor(11,"Dr. Leonardo","KBB");
        Doctor doctor2=new Doctor(22,"Dr. Raphael","Göz");
        Doctor doctor3=new Doctor(33,"Dr. Donatello","Genel Cerrahi");
        this.doctorList.add(doctor1);
        this.doctorList.add(doctor2);
        this.doctorList.add(doctor3);
    }

    //8-doktor listesini yazdırma,tarihler alt alta listelensin
    public void printDoctors(){
        System.out.println(" ---------------------------------Doktorlarımız--------------------------------- ");
        for (Doctor dr:this.doctorList){
            System.out.println("No: "+dr.getId()+" Adı : "+dr.getName()+" Branşı : "+dr.getBranch());
            for (String date:dr.getDates()){
                System.out.println(date);
            }
        }
        System.out.println(" ------------------------------------------------------------------------------- ");

    }


    //9-id si verilen doktoru listeden bulma
    public Doctor findDoctorById(int id){
        for (Doctor dr:this.doctorList){
            if (dr.getId()==id){
                return dr;
            }
        }
        return null;
    }



}
