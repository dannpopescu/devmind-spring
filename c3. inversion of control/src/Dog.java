public class Dog implements IAnimal {

    private String teacherName;

    public Dog(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String makeSound() {
        return "Dog: woof-woof";
    }

    public String getTeacherName() {
        return teacherName;
    }
}
