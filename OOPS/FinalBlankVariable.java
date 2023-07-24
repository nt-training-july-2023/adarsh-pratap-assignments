/**
 * we can initialize the final blank variable in 
 * class constructor .
 */


public class FinalBlankVariable {

    final String panCard ;

    String name ;

   


    String address;


    FinalBlankVariable(String panCard , String name , String address ){
        this.panCard = panCard;
        this.name = name ;
        this.address = address;
    }


     @Override
    public String toString() {
        return "FinalBlankVariable [panCard=" + panCard + ", name=" + name + ", address=" + address + "]";
    }


    


    public static void main(String[] args) {
        
        FinalBlankVariable fi = new FinalBlankVariable("EPMM12345", "Adarsh", "Satna");

        System.out.println(fi);

    }
    
}
