public class b_constructor {
    public static void main(String[] args) {
        Student s1 = new Student("harpreet");
        System.out.println(s1.name);
    }
}

class Student {
    String name;
    int roll;

    //creating constructor
    Student(String name) {
        this.name = name;
    }
}