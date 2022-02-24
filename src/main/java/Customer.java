public class Customer {

    private String id;
    private String name;
    private String mobile;
    private int salary;


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }


    public Customer(String id, String name, String mobile, int salary) {
        System.out.println("Customer Created Fully " + Thread.currentThread());
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.salary = salary;

    }

    public Customer() {
        System.out.println("Customer Created Empty " + Thread.currentThread());
    }




    public void buildMobile() {
        System.out.println("buildMobile called " + Thread.currentThread());

    }


    public void buildName() {
        System.out.println("buildName called " + Thread.currentThread());
        name = "ahmad";
    }


    public void buildId() {
        System.out.println("buildId called " + Thread.currentThread());
        id = "066778989";
    }


}