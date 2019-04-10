package isoccer;

public class TrainingCenter extends Resource {
    private int bedrooms;

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }
    
    @Override
    public void createResource(){
        getResourceData();
        getTrainingCenterData();
    }
    
    public void getTrainingCenterData(){
        System.out.println("[!] Quantos dormitórios terá o novo centro de treinamento? ");
        this.bedrooms = utils.readNumber();
    }
    
    @Override
    public String toString(){
        return "< Código: "+this.getCode()+", Disponível: "+this.isAvailable()+", Recurso: Centro de Treinamento, Dormitórios:"+this.getBedrooms()+" >";
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Centro de Treinamento adicionado! Código: "+ this.getCode());
    }  
}
