package model;

import java.util.Date;

public class AppointmentNurse implements IScheduleable{
    private int id;
    private Patient patient;
    private Nurse Nurse;
    private Date date;
    private String time;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Nurse getNurse() {
        return Nurse;
    }
    public void setNurse(Nurse Nurse) {
        this.Nurse = Nurse;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public void schedule(Date date, String time) {
        
    }

}
