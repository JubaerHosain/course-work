import java.util.List;

public abstract class UserAccountTemplate {
    public void displayAccountInfo(User user) {
        System.out.println("Account Information:");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Address: " + user.getAddress());
        System.out.println();
    }

    public void updateAccountInfo(User user, String name, String email, String address) {
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        System.out.println("Account information updated.");
    }

    public abstract List<Order> getOrderHistory(User user);
}
