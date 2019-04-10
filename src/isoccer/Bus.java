
package isoccer;

public class Bus extends Resource{
   
    @Override
    public String toString(){
        return "< Código: "+this.getCode()+", Disponível: "+this.isAvailable()+", Recurso: Ônibus >";
    }
    
    @Override
    public void sucessMessage(){
        System.out.println("[!] Novo Ônibus adicionado! Código: "+ this.getCode());
    }
    
}
