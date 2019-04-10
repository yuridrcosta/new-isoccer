package isoccer;

public class Resource implements ResourceStrategy {
    
    UtilitySingleton utils = UtilitySingleton.getInstance();
    private int code;
    private boolean available;

    public int getCode() {
        return code;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCode(int code) {
        this.code = code;
    }
        
    @Override
    public void createResource() {
        getResourceData();
    }
    
    public void getResourceData(){
        this.code = utils.resourcesCount + 1000;
        utils.resourcesCount++;
        this.available = true;
    }
    
    @Override
    public String toString(){
        return "< Código: "+this.getCode()+", Disponível: "+this.isAvailable()+ ">";
    }
    
    public void sucessMessage(){
        System.out.println("[!] Recurso registrado com sucesso! Código: "+ this.getCode());
    }
    
}
