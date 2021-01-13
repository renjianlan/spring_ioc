import entity.Student;
import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args){
        //加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Student student= (Student) applicationContext.getBean("student");
        //Student student= (Student) applicationContext.getBean(Student.class);
        //Student student= (Student) applicationContext.getBean("student3");
        System.out.println(student);
        Student stu= (Student) applicationContext.getBean("stu");
        System.out.println(stu);
        User user=(User) applicationContext.getBean("user");
        System.out.println(user);
    }
}
