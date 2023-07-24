package OOPS;

class Encapsulation{

    
    private int id;

    private String name ;

    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    public static void main(String[] args) {

        Encapsulation encapsulation = new Encapsulation();

        encapsulation.setId(1);
        encapsulation.setName("Adarsh Singh Parihar");
        encapsulation.setRole("Software Engineer");

        System.out.println("Id of the Employee is : " + encapsulation.getId() );
        System.out.println("Name of the Employee is : " + encapsulation.getName());
        System.out.println("Role of the Employee is : " + encapsulation.getRole());
        
    }
}