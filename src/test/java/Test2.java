import entity.Student;
import ioc.ApplicationContext;
import ioc.ClassPathXmlApplicationContext;


public class Test2 {
    public static void main(String[] args){
        //加载配置文件，自己实现
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("./src/main/resources/spring.xml");
        Student student= (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
