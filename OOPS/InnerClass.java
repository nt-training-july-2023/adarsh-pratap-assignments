package OOPS;

public class InnerClass {

    private int number = 10;


    class ClassInsideClass{

        int number2 = 200;

        int add(){
            return number+number2;

        }

    }
    
    public static void main(String[] args) {
        InnerClass outerclass = new InnerClass();
        InnerClass.ClassInsideClass innerClass = outerclass.new ClassInsideClass();
        System.out.println(innerClass.add());

        
    }
}
