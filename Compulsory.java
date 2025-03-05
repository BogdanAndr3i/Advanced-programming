// Enum for Project Type
enum ProjectType {
    THEORETICAL, PRACTICAL;
}

//clasa project
class Project {
    private String name;
    private ProjectType type;

    //constructor
    public Project(String name, ProjectType type) {
        this.name = name;
        this.type = type;
    }

    //getters si setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }
//override la fct toString
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}

//clasa student
class Student {
    private String name;
    private int age;
    private Project project;

    //constructor
    public Student(String name, int age, Project project) {
        this.name = name;
        this.age = age;
        this.project = project;
    }

    //getter si setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", project=" + project +
                '}';
    }
}

//clasa mainn
public class Compulsory {
    public static void main(String[] args) {
        //creare de obiecte
        Project project1 = new Project("FAI", ProjectType.THEORETICAL);
        Project project2 = new Project("SO", ProjectType.PRACTICAL);

        Student student1 = new Student("bogdan", 24, project1);
        Student student2 = new Student("cosmin ", 22, project2);

        //afisaj
        System.out.println(student1);
        System.out.println(student2);
    }
}
