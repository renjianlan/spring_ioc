import entity.Car;
import factory.InstanceCarFactory;
import factory.StaticCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-factory.xml");
        Car car= (Car) applicationContext.getBean("car2");
//        InstanceCarFactory instanceCarFactory=new InstanceCarFactory();
//        Car car=instanceCarFactory.getCar(1);
        System.out.println(car);
    }
}
