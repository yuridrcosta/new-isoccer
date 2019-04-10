package isoccer;

public class Employee extends Person {
    
    private float salary;
    String function;

    public Employee() {
    } 
    
    public Employee(String name, String email, String cpf, float salary,int phone,String fct) {
        super(name, email, cpf, phone);
        this.function = fct;
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    @Override
    public void createPerson(){
        getBaseData();
        getEmployeeData();
    }
    
    public void getEmployeeData(){
        System.out.println("[+] Digite o salário do funcionário:");
        this.salary = utils.readFloat();
    }
    
    @Override
    public String toString(){
        return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Salário: "+this.getSalary()+">";
    }
    
    public void sucessMessage(){
        System.out.println("[!] Novo Empregado Adicionado!");
    }
    
}
