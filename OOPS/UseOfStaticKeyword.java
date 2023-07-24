package OOPS;

public class UseOfStaticKeyword {

    private static String companyName= "NucleusTeq";

    private int empId;

    private String empName ;

    private String department ;

    UseOfStaticKeyword(int empId , String empName , String department){

        this.empId = empId;

        this.empName = empName;

        this.department = department;

    }

    @Override
    public String toString() {
        return "UseOfStaticKeyword [comapanyName=" + companyName + ", empId=" + empId + ", empName=" + empName + ", department=" + department + "]";
    }

    public static void main(String[] args) {
        
        UseOfStaticKeyword useOfStaticKeyword = new UseOfStaticKeyword(1 , "Adarsh Singh Parihar" , "IT");
        UseOfStaticKeyword useOfStaticKeyword1 = new UseOfStaticKeyword(2 , "Dewansh" , "HR");

        System.out.println(useOfStaticKeyword);
        System.out.println(useOfStaticKeyword1);

    }
    
}
