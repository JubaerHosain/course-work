package BuilderPattern;

/**
 * Need of Builder Pattern: Method chaining is a useful
 * design pattern but however if accessed concurrently,
 * a thread may observe some fields to contain inconsistent values.
 * */

class User {
    private final String name;
    private final String email;
    private final String phone;
    private final String address;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return this.name + " " + this.email + " " + this.phone + " " + this.address;
    }

    static class UserBuilder {
        private final String name;
        private String email;
        private String phone;
        private String address;

        UserBuilder(String name) {
            this.name = name;
        }

        UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user = new User.UserBuilder("John Doe")
                .email("johndoe@example.com")
                .phone("123-456-7890")
                .address("123 Main St")
                .build();

        System.out.println(user);

        User user1 = new User.UserBuilder("Md. Jubaer")
                .phone("123-456-7890")
                .build();

        System.out.println(user1);
    }
}



public class UserBuilderDemo {
    public static void main(String args[]) {
        User user = new User.UserBuilder("John Doe")
                .email("johndoe@example.com")
                .phone("123-456-7890")
                .address("123 Main St")
                .build();

        System.out.println(user);
    }
}
