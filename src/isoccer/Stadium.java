package isoccer;

import java.util.InputMismatchException;

public class Stadium extends Resource{
    private String name;
    private int capacity;
    private int bathrooms;
    private int snackBars;

    public int getBathrooms() {
        return bathrooms;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSnackBars() {
        return snackBars;
    }

    public String getName() {
        return name;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSnackBars(int snackBars) {
        this.snackBars = snackBars;
    }
    
    @Override
    public void createResource(){
        getResourceData();
        getStadiumData();
    }
    
    public void getStadiumData(){
        this.name = utils.read.nextLine();
        System.out.println("[+] Digite o nome do novo estádio:");
        this.name = utils.read.nextLine();
        System.out.println("[+] Digite a capacidade do novo estádio:");
        this.capacity = utils.readNumber();
        System.out.println("[+] Digite o número de banheiros no novo estádio:");
        this.bathrooms = utils.readNumber();
        System.out.println("[+] Digite o número de lanchonetes no novo estádio:");
        this.snackBars = utils.readNumber();
    }
    
    @Override
    public String toString(){
        return "< Código: "+this.getCode()+", Disponível: "+this.isAvailable()+", Recurso: Estádio, Nome:"+this.getName()+", Capacidade: "+this.getCapacity()+", Banheiros: "+this.getBathrooms()+", Lanchonetes: "+this.getSnackBars()+" >";
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Estádio adicionado! Código: "+ this.getCode());
    }
    
    public void changeCapacity(){
        int rNumber = 0;
            System.out.println("[!] O estádio "+ this.getName() + " tem capacidade para "+ this.getCapacity()+" pessoas!");
        try{
            System.out.println("[+] Digite a nova capacidade do estádio:");
            rNumber = utils.read.nextInt();
        }catch(InputMismatchException error){
            System.out.println("ERRO: Você deve digitar um número!");
        }
    }
    
    public void changeBathrooms(){
        int rNumber = 0;
            System.out.println("[!] O estádio "+ this.getName() + " tem "+ this.getBathrooms()+" banheiros!");
        try{
            System.out.println("[+] Digite a nova quantidade de banheiros:");
            rNumber = utils.read.nextInt();
        }catch(InputMismatchException error){
            System.out.println("ERRO: Você deve digitar um número!");
        }
    }
    
    public void changeSnackBars(){
        int rNumber = 0;
            System.out.println("[!] O estádio "+ this.getName() + " tem "+ this.getSnackBars()+" lanchonetes!");
        try{
            System.out.println("[+] Digite a nova quantidade de lanchonetes:");
            rNumber = utils.read.nextInt();
        }catch(InputMismatchException error){
            System.out.println("ERRO: Você deve digitar um número!");
        }
    }
}
