package trees.BTS;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private String position;
    private String post;

    public Employee(int id, String name, String position, String post) {
        this.name = name;
        this.post = post;
        this.position = position;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", post='" + post + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(position, employee.position) && Objects.equals(post, employee.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, post);
    }

    @Override
    public int compareTo(Employee employee) {
        if (this.id == employee.id){
            return 0;
        } else if (this.id < employee.id) {
            return -1;
        } else {
            return 1;
        }
    }
}
