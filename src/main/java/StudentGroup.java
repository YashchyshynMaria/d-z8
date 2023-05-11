
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentGroup {
    private Student starosta;
    private List<Student> listOfStudents;
    private List<String> listOfTasks;


    public Student getStarosta() {
        return starosta;
    }

    public void setStarosta(Student starosta) {
        this.starosta = starosta;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public List<String> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(List<String> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    StudentGroup(Student starosta, List<Student> listOfStudents, List<String> listOfTasks) {
        this.starosta = starosta;
        this.listOfStudents = listOfStudents;
        this.listOfTasks = listOfTasks;
    }

    public StudentGroup changeStarosta(Student newStarosta) {
        this.starosta = newStarosta;

        return this;
    }

    public void addStudent(Student additionalStudent) {
        this.listOfStudents.add(additionalStudent);
    }

    public Student getStudentById(int id) {
        Student student=null;
        for (int i = 0; i < this.listOfStudents.size(); i++) {
            Student studentByIndex = this.listOfStudents.get(i);
            if (studentByIndex.getId() == id) {
                student = studentByIndex;
            }
        }
        return student;
    }

    public void deleteStudentById(int id) {
        this.listOfStudents.remove(getStudentById(id));
    }

    public void renameStudentById (int id, String newLastName) throws NullPointerException {
        try {
            getStudentById(id).setLastName(newLastName);
        }
        catch (NullPointerException e){
            System.out.println("While renaming Student you used Id which doesn`t exist");
        }
    }

    public void addTaskForGroup(String newTask) {
        this.listOfTasks.add(newTask);
    }

    public void markTaskAsDoneForStudent(int id){
        try {
            getStudentById(id).setTaskDone(true);
        }catch (NullPointerException e){
            System.out.println("While marking tas as done for student you used Id which doesn`t exist");
        }
    }


    public static void main(String[] args) {
        Student student1 = new Student(234, "Maria", "Yashchyshyn");
        Student student2 = new Student(45, "Marta", "Fina");
        Student student3 = new Student(567, "Vlad", "Dmytriv");
        Student student4 = new Student(675, "Taras", "Rudko");
        List<Student> listOfStudent = new ArrayList<>(Arrays.asList(student3, student1, student2));
        StudentGroup studentsGroup = new StudentGroup(student1, listOfStudent, Arrays.asList("task1", "task2"));

        System.out.println(studentsGroup);

        studentsGroup.changeStarosta(student3);
        System.out.println("Students Group after starosta change: " + studentsGroup);

        studentsGroup.addStudent(student4);
        System.out.println("Students Group after adding student: " + studentsGroup);

        studentsGroup.deleteStudentById(45);
        System.out.println("Students Group after deleting student: " + studentsGroup);

        studentsGroup.renameStudentById(3678, "Dmytro");
        System.out.println("Students Group after renaming student:  " + studentsGroup);

        studentsGroup.markTaskAsDoneForStudent(567);
        System.out.println("Students Group after marking task: " + studentsGroup);
    }

    private static List<String> toString(List<Student> listOfStudents){
        List<String> names = new ArrayList<>();

        for (Student student : listOfStudents){
            names.add(student.getFirstName() + " " + student.getLastName());
        }

        return names;
    }

    @Override
    public String toString() {
        return "Starosta of the group: " + this.starosta.getFirstName() + " " + this.starosta.getLastName() + ";" +
                "\nList of students: " + toString(this.listOfStudents) + ";" +
                "\nList of tasks: " + this.listOfTasks + ";";
    }
}
