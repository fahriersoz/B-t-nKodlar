package AppointmentApplication;

//5-Randevu:
//        -no : otomatik üretilsin
//        -hasta adı,Doktor,randevu tarihi
public class Appointment {

    private static int counter=99;

    private int appointmentNo;

    private String name;

    private Doctor doctor;

    private String date;

    public Appointment(String name, Doctor doctor, String date) {
        counter++;
        this.appointmentNo=counter;//100,101,102
        this.name = name;
        this.doctor = doctor;
        this.date = date;
    }

    public int getAppointmentNo() {
        return appointmentNo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
