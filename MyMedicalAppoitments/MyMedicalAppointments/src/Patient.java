
public class Patient {
    int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    Patient (String name, String email){
        this.name = name;
        this.email = email;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return this.weight + " kg";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getHeight() {
        return this.height + " mts";
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
    public String getBlood() {
        return this.blood;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() == 10){
            this.phoneNumber = phoneNumber;
        }else{
            System.out.println("El telefono no es valido");
        }
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setBirthday(String birthday) {
        
        this.birthday = birthday;
    }   
    public String getBirthday() {
        return this.birthday;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
