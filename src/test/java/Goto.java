import entity.Student;
import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Goto {
    public static void main(String[] args){
        //此处可以自定义名
        outer:
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    break outer;
                }
                System.out.println(j);
            }
        }

    }
}
