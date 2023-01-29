package BuilderPattern;

public class Main {
    public static void main(String args[]) {
        User user = new User.UserBuilder("John Doe")
                .email("johndoe@example.com")
                .phone("123-456-7890")
                .address("123 Main St")
                .build();

        System.out.println(user);
    }
}
