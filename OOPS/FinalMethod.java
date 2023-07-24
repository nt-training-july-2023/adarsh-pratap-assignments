/**
 * we can not override the final method 
 * 
 * 
 * if we made a class final we can not extend it but in making final methods we cannot override the method
 * 
 * but we can extends the class
 */

public class FinalMethod extends ArithematicOperations{


    @Override
    String name(){
        return "My name is 2Pac";
    }



    public static void main(String[] args) {
        
        FinalMethod finalMethod = new FinalMethod();

        System.out.println(finalMethod.name());
        System.out.println(finalMethod.additionOfTwo(12.22f, 12.22f));

    }

    
}

class ArithematicOperations {

    String name(){
        return "My Name is Eminem";
    }

    final float additionOfTwo(float a  , float b){
        return a+b;
    }

    final float multiOftwo(float a , float b){
        return a*b;
    }
}