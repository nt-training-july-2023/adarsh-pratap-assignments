package OOPS;

import java.lang.reflect.Method;

public class MethodInnerClass {

    void classInsideMethod(){

        class InnerClass{

            void print(){
                System.out.println("Iam inside the method inner class");
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.print();
    }

    public static void main(String[] args) {

        MethodInnerClass methodInnerClass = new MethodInnerClass();
        methodInnerClass.classInsideMethod();
        
    }
    
}
