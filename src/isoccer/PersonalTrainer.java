package isoccer;

public class PersonalTrainer extends Employee {
    
    @Override
    public String toString(){
        return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Salário: "+this.getSalary()+", Função: Preparador Físico >";
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Preparador Físico adicionado!");
    }
    
}
