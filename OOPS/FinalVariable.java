package OOPS;

public class FinalVariable {

    final float pi = 3.14f;
    
    float area(float radius ){
        return (pi*radius*radius);
    }

    public static void main(String[] args) {
        
        FinalVariable fi = new FinalVariable();

        System.out.println(fi.area(2));
    }

}
