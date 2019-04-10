package isoccer;


public class President extends Employee {
    @Override
    public String toString(){
        return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Salário: "+this.getSalary()+", Função: Presidente >";
    }
    
    @Override
    public void createPerson(){
        getBaseData();
        getEmployeeData();
        super.function = "Presidente";
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Presidente adicionado!");
    }
}
