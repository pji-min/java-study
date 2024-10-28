import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private List<ToDoList> works = new ArrayList<>();

    public static void main(String[] args) {
        Main todo = new Main();
        boolean run = true;

        while (run) {
            System.out.print("\n메서드 이름을 입력하세요 <add, query, check, delete, exit>: ");
            String name = todo.scanner.nextLine();

            switch (name) {
                case "add":
                    todo.add();
                    break;
                case "query":
                    todo.query();
                    break;
                case "check":
                    todo.check();
                    break;
                case "delete":
                    todo.delete();
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 메서드 이름입니다~ ");
            }
        }

        todo.closeScanner();
    }

    public void add() {
        System.out.print("제목을 입력해주세요: ");
        String title = scanner.nextLine();
        System.out.print("내용을 입력해주세요: ");
        String content = scanner.nextLine();

        works.add(new ToDoList(title, content));
    }

    public void query() {
        if (works.isEmpty()) {
            System.out.println("할 일 목록이 비어 있습니다");
        } else {
            System.out.println("- 할 일 목록\n-------------");
            for (ToDoList work : works) {
                System.out.println(work);
                System.out.println("-------------");
            }
        }
    }

    public void check() {
        System.out.print("완료할 할 일의 제목을 입력해주세요: ");
        String title = scanner.nextLine();

        for (ToDoList work : works) {
            if (work.getTitle().equals(title)) {
                work.check();
                System.out.println("할 일이 완료되었습니다");
            }
        }
        System.out.println("해당 할 일이 목록에 없습니다");
    }

    public void delete() {
        System.out.print("삭제할 할 일의 제목을 입력해주세요: ");
        String title = scanner.nextLine();

        works.removeIf(work -> work.getTitle().equals(title));
        System.out.println("할 일이 삭제되었습니다");
    }

    public void closeScanner() {
        scanner.close();
    }
}
