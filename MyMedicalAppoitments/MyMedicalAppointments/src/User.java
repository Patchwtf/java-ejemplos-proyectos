
public class User {

    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("El telefono no es valido");
        }
    }

    @Override
    public String toString() {
        return "User: Nombre: " + name + "\nEmail: " + email + "\nDireccion: " + address + "\nTelefono: " + phoneNumber;
    }
}
