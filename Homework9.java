import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Homework9 {
    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>();
        File dbFile = new File("db.txt");

        try (Scanner fileScanner = new Scanner(dbFile)) {
            while (fileScanner.hasNext()) {
                String id = fileScanner.next().trim();
                if (!fileScanner.hasNext()) {
                    break;
                }
                String password = fileScanner.next().trim();
                members.put(id, password);
            }
        } catch (FileNotFoundException e) {
            System.out.println("db.txt 파일을 찾을 수 없습니다: " + e.getMessage());
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("id와 password를 입력해주세요.");

                System.out.print("id : ");
                String id = scanner.nextLine().trim();

                if (!members.containsKey(id)) {
                    System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                    continue;
                }

                System.out.print("password : ");
                String password = scanner.nextLine().trim();

                if (members.get(id).equals(password)) {
                    System.out.println("id와 비밀번호가 일치합니다.");
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                }
            }
        }
    }
}
