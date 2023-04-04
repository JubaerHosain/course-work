public class User {
    private String name;
    private String email;
    private String password;
    private String address;

    public User(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
    }

    public void setEmail(String email) {
    }

    public void setAddress(String address) {
    }
}
