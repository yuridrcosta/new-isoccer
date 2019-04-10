package isoccer;


public class Cooker extends Employee {
    @Override
    public String toString(){
        return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Salário: "+this.getSalary()+", Função: Cozinheiro >";
    }
    
    @Override
    public void createPerson(){
        getBaseData();
        getEmployeeData();
        super.function = "Cozinheiro";
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Cozinheiro adicionado!");
    }
}
