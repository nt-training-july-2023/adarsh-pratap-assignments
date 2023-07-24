public class StaticInnerClass {

    static class ClassInsideClass{

        static int number = 100;

        int number1 = 200;

        void print(){ 
            System.out.println("Printing the static variable : " + number + " but You can not use non static variable on static Inner Class ");
        }
    }

    public static void main(String[] args) {
        StaticInnerClass.ClassInsideClass cl = new StaticInnerClass.ClassInsideClass();

        cl.print();
    }
    
}
