import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Work {
    private Scanner scanner = new Scanner(System.in);
    private List<String> works = new ArrayList<>();
    private List<String> completedWorks = new ArrayList<>();

    public void add() {
        System.out.println("할 일을 입력해주세요: ");
        String work = scanner.nextLine();
        works.add(work);

    }

    public void query() {
        if (works.isEmpty()) {
            System.out.println("할 일 목록이 비어 있습니다");
        } else {
            System.out.println("할 일 목록:");
            for (String w : works) {
                System.out.println(w);
            }
        }

        if (completedWorks.isEmpty()) {
            System.out.println("완료된 할 일 목록이 비어 있습니다");
        } else {
            System.out.println("완료된 할 일 목록:");
            for (String completedWork : completedWorks) {
                System.out.println(completedWork);
            }
        }
    }

    public void check() {
        System.out.println("완료할 할 일을 입력해주세요: ");
        String check = scanner.nextLine();

        if (works.remove(check)) {
            completedWorks.add(check);
            System.out.println("할 일이 완료되었습니다!: " + check);
        } else {
            System.out.println("해당 할 일이 목록에 없습니다");
        }
    }

    public void delete() {
        System.out.println("삭제할 할 일을 입력해주세요: ");
        String delete = scanner.nextLine();

        if (works.remove(delete)||completedWorks.remove(delete)) {
            System.out.println("할 일이 삭제되었습니다: " + delete);
        } else {
            System.out.println("해당 할 일이 목록에 없습니다");
        }
    }

    public void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        Work work = new Work();
        boolean run = true;

        while (run) {
            System.out.print("\n메서드 이름을 입력하세요 (add, query, check, delete, exit): ");
            String name = work.scanner.nextLine();

            switch (name) {
                case "add":
                    work.add();
                    break;
                case "query":
                    work.query();
                    break;
                case "check":
                    work.check();
                    break;
                case "delete":
                    work.delete();
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 메서드 이름입니다 ~");
            }
        }

        work.closeScanner();
    }
}
