
package isoccer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class UtilitySingleton {
    
    
    Scanner read = new Scanner(System.in);
    private static UtilitySingleton instance = new UtilitySingleton();
    private RegistersSingleton regs = RegistersSingleton.getInstance();
    
    int resourcesCount = 0;

    private UtilitySingleton() {
    }
    
    public static synchronized UtilitySingleton getInstance(){
        return instance;
    }
    
    int readNumber(){
        int rNumber = 0;
        
        try{
            rNumber = read.nextInt();
        }catch(InputMismatchException error){
            System.out.println("ERRO: Você deve digitar um número!");
        }
            
        return rNumber;
    }
    
    Float readFloat(){
        float rFloat = 0;
        
        try{
            rFloat = read.nextFloat();
        }catch(InputMismatchException error){
            System.out.println("ERRO: Você deve digitar um número real (float)! (Formato: XX,X)");
        }
        
        return rFloat;
    }
    
    public void employeesReport(){
                regs = RegistersSingleton.getInstance();
                System.out.println("[!] Número total de funcionários: "+regs.employees.size());
                System.out.println("[!] -> Técnico:");
                System.out.println("");
                System.out.println("        [!] Nome: "+regs.mainCoach.getName()+" [!] Email: "+regs.mainCoach.getEmail());
                System.out.println("        [!] Salário: "+regs.mainCoach.getSalary()+" [!] Telefone: "+regs.mainCoach.getPhone());
                System.out.println("[!] -> Jogadores:");
                System.out.println("");
                listPlayers();
                System.out.println("[!] Número de funcionários de serviços gerais: "+regs.employees.size());
                listEmployees();
    }
    
    public void listPlayers(){
        regs = RegistersSingleton.getInstance();
        Player st;
        for (PlayerIterator it = new PlayerIterator(regs.players); it.hasNext();){
            st = it.next();
            
            System.out.println("        [!] Nome: "+st.getName());
            System.out.println("        [!] Email: "+st.getEmail());
            System.out.println("        [!] CPF: "+st.getCpf()+" Telefone: "+st.getPhone());
            System.out.println("        [!] Salário: "+st.getSalary());
            System.out.println("        [!] Posição: "+st.getPosition()+" [!] Apto a jogar: "+st.isHealthy());
            System.out.println("");
        }
    }
    
    public void listEmployees(){
        regs = RegistersSingleton.getInstance();
        Employee st;
        for (EmployeeIterator it = new EmployeeIterator(regs.employees); it.hasNext();){
            st = it.next();
            
            System.out.println("        [!] Nome: "+st.getName());
            System.out.println("        [!] Email: "+st.getEmail());
            System.out.println("        [!] CPF: "+st.getCpf()+" Telefone: "+st.getPhone());
            System.out.println("        [!] Salário: "+st.getSalary());
            System.out.println("        [!] Função: "+st.getFunction());
            System.out.println("");
        }
    }
    
    public void listPartners(){
        regs = RegistersSingleton.getInstance();
        Partner ct;
        for (PartnerIterator it = new PartnerIterator(regs.partners); it.hasNext();) {
            ct = it.next();
            
            System.out.println("        [!] Nome: " + ct.getName());
            System.out.println("        [!] Email: "+ ct.getEmail()+" [!] CPF: "+ct.getCpf());
            System.out.println("        [!] Telefone: "+ct.getPhone()+" [!] Contribuição: "+ct.getContribution());
            
            if(ct.isCompliance()){
                System.out.println("        [!] Adimplência: Adimplente");
            }else{
                System.out.println("        [!] Adimplência: Inadimplente");
            }
            
            switch(ct.getType()){
                case 1:
                    System.out.println("        [!] Tipo: Júnior");
                    break;
                case 2:
                    System.out.println("        [!] Tipo: Sênior");
                    break;
                case 3:
                    System.out.println("        [!] Tipo: Elite");
                break;
            }
            System.out.println("");
        }
    }
    
    public void listResources(){
        regs = RegistersSingleton.getInstance();
        Resource ct;
        
        System.out.println("[!] O clube possuí "+ regs.resources.size()+" recursos físicos!");
        for(ResourceIterator it = new ResourceIterator(regs.resources);it.hasNext();){
            ct = it.next();
            System.out.println(ct.toString());
        }
    }
    
    public void showMainMenu(){
        System.out.println("[+] Digite o NÚMERO correspondente a opção desejada:");
        System.out.println("    [1] Gerenciar funcionários");
        System.out.println("    [2] Gerenciar recursos físicos");
        System.out.println("    [3] Gerenciar sócios-torcedores");
        System.out.println("    [4] Relatórios");
        System.out.println("    [0] Sair");
    }
    
    public void showReportsMenu(){
        System.out.println("[+] Digite o NÚMERO correspondente a opção desejada:");
        System.out.println("    [1] Geral");
        System.out.println("    [2] Sobre os funcionários");
        System.out.println("    [3] Sobre os recursos físicos");
        System.out.println("    [4] Sobre os sócios torcedores");
    }
    
    public void showManagePartnersMenu(){
        System.out.println("[+] Digite o NÚMERO correspondente a opção desejada:");
        System.out.println("    [1] Adicionar sócio-torcedor");
        System.out.println("    [2] Buscar dados de sócio-torcedor");
        System.out.println("    [3] Alterar status de adimplência de sócio-torcedor");
        System.out.println("    [0] Sair");
    }
   
    public void showManageResourcesMenu(){
        System.out.println("[+] Digite o NÚMERO correspondente a opção desejada:");
        System.out.println("    [1] Adicionar estádio");
        System.out.println("    [2] Adicionar centro de treinamento");
        System.out.println("    [3] Adicionar ônibus");
        System.out.println("    [4] Verificar dados de recursos");
        System.out.println("    [5] Aumentar capacidade de estádio");
        System.out.println("    [6] Aumentar número de lanchonetes de estádio");
        System.out.println("    [7] Aumentar número de banheiros de estádio");
        System.out.println("    [8] Alterar status de disponibilidade");
        System.out.println("    [0] Sair");
    }
    
    public void showAddEmployeeMenu(){
        System.out.println("[+] Digite o NÚMERO correspondente a opção desejada:");
        System.out.println("    [1] Adicionar jogador");
        System.out.println("    [2] Adicionar técnico");
        System.out.println("    [3] Adicionar presidente");
        System.out.println("    [4] Adicionar médico");
        System.out.println("    [5] Adicionar preparador físico");
        System.out.println("    [6] Adicionar advogado"); 
        System.out.println("    [7] Adicionar cozinheiro");
        System.out.println("    [8] Adicionar motorista");
        System.out.println("    [0] Sair");
    }
    
    public void showEmployeesMenu(){
        System.out.println("[+] Digite o NÚMERO correspondente a opção desejada:");
        System.out.println("    [1] Adicionar funcionário");
        System.out.println("    [2] Remover funcionário");
        System.out.println("    [3] Buscar dados de funcionário");
        System.out.println("    [4] Alterar status de saúde de jogador");
        System.out.println("    [0] Sair");
    }
}
