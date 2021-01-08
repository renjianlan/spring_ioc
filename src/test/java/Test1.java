import entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args){
        //加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        //Student student= (Student) applicationContext.getBean("student");
        //Student student= (Student) applicationContext.getBean(Student.class);
        Student student= (Student) applicationContext.getBean("student3");
        System.out.println(student);
    }
}
