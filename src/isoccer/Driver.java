
package isoccer;

public class Driver extends Employee {
    private int drivingLicense;

    public int getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(int drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
    
    @Override
    public String toString(){
        return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Salário: "+this.getSalary()+", Função: Motorista, Licensa de Motorista: "+this.drivingLicense+">";
    }
    
    @Override
    public void createPerson(){
        getBaseData();
        getEmployeeData();
        getDriverData();
        super.function = "Motorista";
    }
     
    public void getDriverData(){
        System.out.println("[+] Digite o número da carteira de motorista: (SOMENTE NÚMEROS)");
        this.drivingLicense = utils.readNumber();
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Motorista adicionado!");
    }
}
