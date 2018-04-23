import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: cmj
 * @Description:
 * @Date: 2018/4/19
 */
public class LambdaDemo {
    public List<Student> students = Arrays
            .asList(new Student(18, "LiLei", true), new Student(19, "Jack", true), new Student(16, "Mei", false),
                    new Student(17, "Andy", false),new Student(17, "Cmj", true));

    /**
     * 转化为其他集合
     */

    public void convertToCollection() {
        //转hashMap
        Map<String, Long> map = students.stream().collect(Collectors.toMap(Student::getName, Student::getAge));
        System.out.println(map);
        //转setTree
        TreeSet<Student> set = students.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);
    }

    /**
     *数组计算
     */
    public void convertToValue() {
        //选出最大值
        Student student = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge))).get();
        System.out.println(student);
        // summingDouble ：计算 double 类型数值的和；summingInt：计算 int 类型数值的和；summingLong：计算 long 类型数值的和；
        double age = students.stream().collect(Collectors.averagingDouble(Student::getAge));
        System.out.println(age);
        //  计算总和
        long sum = students.stream().collect(Collectors.summingLong(Student::getAge));
        System.out.println(sum);
    }

    /**
     * 数据分组
     */

    public void group() {
        Map<Boolean, List<Student>> block = students.stream().collect(Collectors.partitioningBy(Student::isMan));
        System.out.println(block);
        Map<Long,List<Student>> group=students.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(group.toString());

    }

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.convertToCollection();
        lambdaDemo.convertToValue();
        lambdaDemo.group();
    }

}
