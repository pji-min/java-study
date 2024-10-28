public class ToDoList {
    String title;
    String content;
    boolean checked;

    public ToDoList(String title, String content) {
        this.title = title;
        this.content = content;
        this.checked = false;
    }

    @Override
    public String toString() {
        return String.format("제목 : %s\n할일 : %s\n완료여부 : %s",
                title, content, (checked ? "완료" : "미완료"));
    }

    public void check() {
        checked = true;
    }

    public String getTitle() {
        return title;
    }
}

