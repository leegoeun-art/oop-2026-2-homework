import java.util.Scanner;

// 학번, 이름, 전공, 전화번호를 속성으로 가지는 Student 클래스
class Student {
    int studentId;    // 학번 (숫자로 저장)
    String name;      // 이름
    String major;     // 전공
    long phone;       // 전화번호 (숫자로 저장: 01053559999 -> 1053559999)

    Student(int studentId, String name, String major, long phone) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.phone = phone;
    }

    // getter
    int getStudentId() { return studentId; }
    String getName() { return name; }
    String getMajor() { return major; }
    long getPhone() { return phone; }

    // setter
    void setStudentId(int studentId) { this.studentId = studentId; }
    void setName(String name) { this.name = name; }
    void setMajor(String major) { this.major = major; }
    void setPhone(long phone) { this.phone = phone; }

    // 숫자로 저장된 전화번호를 010-xxxx-xxxx 형태의 문자열로 만듦
    String getPhoneString() {
        String digits = "0" + Long.toString(phone);   // 사라진 앞자리 0 복구
        if (digits.length() == 11) {
            return digits.substring(0, 3) + "-" + digits.substring(3, 7) + "-" + digits.substring(7);
        } else {
            return digits.substring(0, 3) + "-" + digits.substring(3, 6) + "-" + digits.substring(6);
        }
    }

    // 학생 정보 출력
    void printInfo() {
        System.out.println(studentId + " " + name + " " + major + " " + getPhoneString());
    }
}

public class Homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");
            int studentId = Integer.parseInt(scanner.next());
            String name = scanner.next();
            String major = scanner.next();
            long phone = Long.parseLong(scanner.next());
            students[i] = new Student(studentId, name, major, phone);
        }

        System.out.println();
        System.out.println("입력된 학생들의 정보는 다음과 같습니다.");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + "번째 학생: ");
            students[i].printInfo();
        }
    }
}
