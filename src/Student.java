import java.io.*;

public class Student implements Serializable {
    private String name;
    private String surname;
    private String email;
    private transient String password;

    public Student(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Student student1 = new Student("Jan","Kowalski", "kowalski@gmail.com", "haslo123");
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Student.bin"))){
            o.writeObject(student1);} catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream i = new ObjectInputStream(new FileInputStream("Student.bin"))){
            Student studentRead = (Student) i.readObject();
            System.out.println(studentRead.name);
            System.out.println(studentRead.surname);
            System.out.println(studentRead.email);
            System.out.println(studentRead.password);

            ;} catch (IOException | ClassNotFoundException e) {

        }

    }
}
