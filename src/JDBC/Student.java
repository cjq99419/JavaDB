package JDBC;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/7 0007 下午 02:58
 * @Notes NULL
 */
public class Student {
    public int id;
    public String name;
    public int classes;
    public int grades;
    public int age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes=" + classes +
                ", grades=" + grades +
                ", age=" + age +
                '}';
    }
}
