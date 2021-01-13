package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    //private List<Address> addresses;
    private Address address;

    public Student(){
        System.out.println("创建了Student对象");
    }
}
