/*
 * 
 * We can not Inherited the Final class 
 * we cannot extend it 
 */

public class FinalClass{
    public static void main(String[] args) throws Exception{
        Test test = new Test("12345" , "7453745647252835252542524" , "Adarsh");

    }
}

final class Test{

    private  String accountNumber = "Adarsh";

    private String balance ;

    private String name;
    
    
    
    public Test(String accountNumber, String balance, String name) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }

}



