package AppointmentApplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//3-Doktor:
//        -id, isim, branş, takvim
//        -takvim: sistemin kullanıldığı günden 1 gün sonra başlamak üzere
//        7 günlük uygun randevu tarihleri
public class Doctor {

    private int id;

    private String name;

    private String branch;

    private List<String> dates=new ArrayList<>();

    public Doctor(int id, String name, String branch) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        //4-doktor objesi oluştuğunda sistemin tarihinden 1 gün sonrası ile başlayan
        //7 günlük takvim oluşsun
        LocalDate day=LocalDate.now();//26.09
        for (int i=0;i<3;i++){//test için 3 e düşürdük
            day=day.plusDays(1);//27.09,28.09,29.09,02.10,03.10
            if (day.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                day=day.plusDays(1);
            } else if (day.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                day=day.plusDays(2);//02.10
            }
            this.dates.add(day.toString());
        }
    }
    //getter-setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }
}
