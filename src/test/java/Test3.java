import entity.Student;
import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args){
        //加载配置文件
        //ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-dependencies.xml");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-p.xml");
        Student student=(Student)applicationContext.getBean("student");
        System.out.println(student);
    }
}
