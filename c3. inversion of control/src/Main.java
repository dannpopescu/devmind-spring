import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        IAnimal cat = ctx.getBean("cat", IAnimal.class);
        Dog dog = ctx.getBean(Dog.class);

        System.out.println(cat.makeSound());
        System.out.println(dog.makeSound());
        System.out.println(dog.getTeacherName());
    }
}
