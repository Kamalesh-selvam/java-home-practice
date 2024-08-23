import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymMembershipSystem {
    private static List<Member> members = new ArrayList<>();
    private static final String URL = "jdbc:mysql://localhost:3306/gym";
    private static final String USER = "kamal";
    private static final String PASSWORD = "kamal975";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter gym member details:");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();

            System.out.print("Contact Number: ");
            String contactNumber = scanner.nextLine();

            System.out.print("Emergency Contact Number: ");
            String emergencyContact = scanner.nextLine();

            System.out.print("Blood Group: ");
            String bloodGroup = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            // Create a new member
            Member newMember = new Member(name, dob, contactNumber, emergencyContact, bloodGroup, address, email);
            members.add(newMember);

            System.out.println("\nMember added successfully!");
            System.out.println(newMember);

            // Insert member into the database
            insertMemberIntoDatabase(newMember);

            System.out.print("\nWould you like to add another member? (yes/no): ");
            String response = scanner.nextLine();

            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }

    private static void insertMemberIntoDatabase(Member member) {
        String query = "INSERT INTO members (name, dob, contactNumber, emergencyContact, bloodGroup, address, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getDob());
            pstmt.setString(3, member.getContactNumber());
            pstmt.setString(4, member.getEmergencyContact());
            pstmt.setString(5, member.getBloodGroup());
            pstmt.setString(6, member.getAddress());
            pstmt.setString(7, member.getEmail());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error inserting member into database: " + e.getMessage());
        }
    }
}
