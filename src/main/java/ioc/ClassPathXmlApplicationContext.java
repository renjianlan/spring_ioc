package ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    Map<String,Object> ioc=new HashMap<String,Object>();
    public ClassPathXmlApplicationContext(String path){
        try{
            SAXReader reader=new SAXReader();
            Document document=reader.read(path);
            Element root=document.getRootElement();
            Iterator<Element> iterator=root.elementIterator();
            while(iterator.hasNext()){
                Element element=iterator.next();
                String id=element.attributeValue("id");
                String className=element.attributeValue("class");
                Class clazz=Class.forName(className);
                //获取无参构造函数，创建目标对象
                Constructor constructor=clazz.getConstructor();
                Object object=constructor.newInstance();
                //给目标对象赋值,迭代每个bean下的property属性
                Iterator<Element> beanIterator=element.elementIterator();
                while(beanIterator.hasNext()){
                    Element propertyElement=beanIterator.next();
                    String name=propertyElement.attributeValue("name");
                    String valueStr=propertyElement.attributeValue("value");
                    String ref=propertyElement.attributeValue("ref");
                    if(ref==null) {
                        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                        //获取某个公共字段
                        Field field = clazz.getDeclaredField(name);
                        //得到set方法，第一个参数为方法名，第二个为参数类型
                        Method method = clazz.getDeclaredMethod(methodName, field.getType());
                        //根据成员变量的数值类型，将值进行转换
                        Object value = null;
                        if (field.getType().getName() == "int") {
                            value = Integer.parseInt(valueStr);
                        }
                        if (field.getType().getName() == "java.lang.String") {
                            value = valueStr;
                        }
                        if (field.getType().getName() == "long") {
                            value = Long.parseLong(valueStr);
                        }
                        //赋值，第一个参数为对象，第二个为值
                        method.invoke(object, value);
                    }
                }
                ioc.put(id,object);
            }
//            Object obj1=ioc.get("address");
//            Object obj2=ioc.get("student");

        }catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public Object getBean(String id) {
        return ioc.get(id);
    }
}
