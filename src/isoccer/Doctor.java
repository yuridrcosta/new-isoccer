package isoccer;

public class Doctor extends Employee{
    private int crm;

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }
    
    @Override
    public void createPerson(){
        getBaseData();
        getEmployeeData();
        getDoctorData();
        super.function = "Médico";
    }
    
    public void getDoctorData(){
        System.out.println("[+] Digite o número do CRM do médico: (SOMENTE NÚMEROS)");
        this.crm = utils.readNumber();
    }
    
    @Override
    public String toString(){
       return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Salário: "+this.getSalary()+", Função: Médico, CRM: "+this.crm+">";
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Médico adicionado!");
    }
}
