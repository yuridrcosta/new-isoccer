package isoccer;

public class Player extends Employee {
    
    private String position;
    private boolean healthy;

    public boolean isHealthy() {
        return healthy;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }
    
    @Override
    public void createPerson(){
        getBaseData();
        getEmployeeData();
        getPlayerData();
        super.function = "Jogador";
    }
    
    public void getPlayerData(){
        this.healthy = true;
        this.position = utils.read.nextLine();
        System.out.println("[+] Digite a posição do jogador:");
        this.position = utils.read.nextLine();
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Jogador adicionado!");
    }
    
    @Override
    public String toString(){
       return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Salário: "+this.getSalary()+", Função: Jogador, Posição: "+this.getPosition()+", Saudável: "+this.isHealthy()+" >";
    }
    
}
