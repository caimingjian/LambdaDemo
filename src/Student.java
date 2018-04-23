/**
 * @Author: cmj
 * @Description:
 * @Date: 2018/4/19
 */
public class Student implements Comparable {
    long age;//年龄
    String name;//姓名
    boolean man;//性别男

    public Student(long age, String name, boolean isMan) {
        this.age = age;
        this.name = name;
        this.man = isMan;
    }
    public long getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public boolean isMan() {
        return man;
    }
    @Override
    public String toString() {
        return "(" + age + ", " + name + ", "
                + (man ? "man":"woman") + ")";
    }
    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        return (int)(age - student.getAge());
    }
}