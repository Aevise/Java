package base;

public class Osoba {
    String first_name;
    String last_name;
    String email;
    String ip_address;

    public Osoba(String first_name, String last_name, String email, String ip_address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.ip_address = ip_address;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", ip_address='" + ip_address + '\'' +
                '}';
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getIp_address() {
        return ip_address;
    }
}
