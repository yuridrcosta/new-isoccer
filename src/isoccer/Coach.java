
package isoccer;

public class Coach extends Employee {
    @Override
    public String toString(){
        return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Salário: "+this.getSalary()+", Função: Treinador >";
    }
    
    @Override
    public void createPerson(){
        getBaseData();
        getEmployeeData();
        super.function = "Técnico";
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Treinador adicionado!");
    }
}
