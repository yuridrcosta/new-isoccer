package isoccer;

public class Partner extends Person {
    private float contribution;
    private boolean compliance;
    private int type;

    public float getContribution() {
        return contribution;
    }

    public int getType() {
        return type;
    }

    public boolean isCompliance() {
        return compliance;
    }

    public void setCompliance(boolean compliance) {
        this.compliance = compliance;
    }

    public void setContribution(float contribution) {
        this.contribution = contribution;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    @Override
    public void createPerson() {
        getBaseData();
        getPartnerData();
    }
    
    public void getPartnerData(){
        this.compliance = true;
        System.out.println("[+] Digite o valor da contribuição do sócio-torcedor: (REAL) (Formato: XX,X)");
        this.contribution = utils.readFloat();
        System.out.println("[+] Digite o NÚMERO correspondente ao tipo de sócio-torcedor:");
        System.out.printf("     [1] Júnior\n     [2] Sênior\n     [3] Elite\n");
        this.type = utils.readNumber();
    }
    
    @Override
    public String toString(){
        return "< Nome:"+this.getName()+", E-mail: "+this.getEmail()+", CPF: "+this.getCpf()+", Telefone: "+this.getPhone()+", Contribuição: "+ this.contribution+" >";
    }
    
}
