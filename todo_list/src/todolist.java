class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class ToDoList {
    Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addTask(String task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    public void displayTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void removeTask(String task) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.data.equals(task)) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();

        // 할 일 추가
        todoList.addTask("공부하기");
        todoList.addTask("운동하기");
        todoList.addTask("책 읽기");

        // 할 일 출력
        System.out.println("할 일 목록:");
        todoList.displayTasks();

        // 할 일 삭제
        todoList.removeTask("운동하기");

        // 삭제 후 할 일 목록 출력
        System.out.println("\n운동하기를 삭제한 후 할 일 목록:");
        todoList.displayTasks();
    }
}