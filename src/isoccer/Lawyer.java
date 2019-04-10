
package isoccer;

public class Lawyer extends Employee {
    @Override
    public String toString(){
        return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Salário: "+this.getSalary()+", Função: Advogado >";
    }
    
    @Override
    public void createPerson(){
        getBaseData();
        getEmployeeData();
        super.function = "Advogado";
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Advogado adicionado!");
    }
}
