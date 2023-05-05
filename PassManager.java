import java.util.HashMap;
import java.util.Scanner;

public class PassManager {

    private static HashMap<String, String> passwords = new HashMap<String, String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Enter a command (add, remove, search, exit): ");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    addPassword(scanner);
                    break;
                case "remove":
                    removePassword(scanner);
                    break;
                case "search":
                    searchPasswords(scanner);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private static void addPassword(Scanner scanner) {
        System.out.println("Enter a website or service name: ");
        String website = scanner.nextLine();
        System.out.println("Enter a username: ");
        String username = scanner.nextLine();
        System.out.println("Enter a password: ");
        String password = scanner.nextLine();
        passwords.put(website,password);
        System.out.println("Password added successfully.");
    }

    private static void removePassword(Scanner scanner) {
        System.out.println("Enter a website or service name: ");
        String website = scanner.nextLine();
        if (passwords.containsKey(website)) {
            passwords.remove(website);
            System.out.println("Password removed successfully.");
        } else {
            System.out.println("Password not found.");
        }
    }

    private static void searchPasswords(Scanner scanner) {
        System.out.println("Enter a website or service name: ");
        String website = scanner.nextLine();
        if (passwords.containsKey(website)) {
            String password = passwords.get(website);
            System.out.println("Username: " + website);
            System.out.println("Password: " + password);
        } else {
            System.out.println("Password not found.");
        }
    }
}
