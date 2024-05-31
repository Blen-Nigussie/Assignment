package IndividualAsssignment1;
    public class Task {
        private String title;
        private String description;
        private boolean completed;

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.completed = false;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }

        public boolean isCompleted() {
            return this.completed;
        }

        public void markCompleted() {
            this.completed = true;
        }
    }

    class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    class ToDoList {
        private Node head;

        public ToDoList() {
            this.head = null;
        }

        public void addToDo(Task task) {
            Node newNode = new Node(task);

            if (this.head == null) {
                this.head = newNode;
            } else {
                Node current = this.head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void markToDoAsCompleted(String title) {
            Node current = this.head;
            while (current != null) {
                if (current.task.getTitle().equals(title)) {
                    current.task.markCompleted();
                    return;
                }
                current = current.next;
            }
            System.out.println(" Title '" + title + "' not found in the to-do list.");
        }

        public void viewToDoList() {
            Node current = this.head;
            if (current == null) {
                System.out.println("To-Do List is empty.");
            } else {
                System.out.println("To-Do List:");
                while (current != null) {
                    System.out.println("- " + current.task.getTitle() + " (" + (current.task.isCompleted() ? "Completed" : "Incomplete") + ")");
                    current = current.next;
                }
            }
        }
        public static void main(String[] args) {
            ToDoList toDoList = new ToDoList();
            toDoList.addToDo(new Task("Study DSA", "Complete time complexity"));
            toDoList.addToDo(new Task("Study Applied math", "Complete differential equation"));
            toDoList.addToDo(new Task("Wash cloth", "Wash all cloths"));
            toDoList.viewToDoList();
            toDoList.markToDoAsCompleted("Study Applied math");
            toDoList.viewToDoList();
        }
    }

