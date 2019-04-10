package isoccer;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistersSingleton {
    public Employee emptyPosition = new Employee("Posição não ocupada","ascom@meutimefc.com","xxx.xxx.xxx-xx",0,0,"Função disponível");
    private UtilitySingleton utls = UtilitySingleton.getInstance();
    private PersonStrategy person;
    private static RegistersSingleton instance = new RegistersSingleton();
    
    ArrayList<Partner> partners = new ArrayList<Partner>();
    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Player> players = new ArrayList<Player>();
    Employee mainCoach = emptyPosition;
    Employee president = emptyPosition;
    ArrayList<Resource> resources = new ArrayList<Resource>();
   
    
    private RegistersSingleton(){
        
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }
    
    public static synchronized RegistersSingleton getInstance(){     
        return instance;
    }
    
    public void addResource(Resource r){
        r.createResource();
        resources.add(r);
        r.sucessMessage();
    }
    
    public void addCoach(){
        Coach newCoach = new Coach();
        newCoach.createPerson();
        mainCoach = newCoach;
        employees.add(mainCoach);
        newCoach.sucessMessage();
    }
    
    public void addPresident(){
        President newPresident = new President();
        newPresident.createPerson();
        president = newPresident;
        employees.add(president);
        newPresident.sucessMessage();
    }
    
    public void addPlayer(){
        Player newPlayer = new Player();
        newPlayer.createPerson();
        players.add(newPlayer);
        Employee newPl = (Employee) newPlayer;
        employees.add(newPl);
        newPlayer.sucessMessage();
    }
    
    public void addPartner(){
        person = new Partner();        
        person.createPerson();
        Partner newPartner = (Partner) person;
        partners.add(newPartner);
        System.out.println("[!] Novo sócio-torcedor adicionado!");
    }
    
    public void addEmployee(Person p){
        p.createPerson();
        Employee newEmployee = (Employee) p;
        employees.add(newEmployee);
        newEmployee.sucessMessage();
    }
    
    Player findPlayer(String name){
        String nm;
        Player st = null;
        int exit = 0;
        

        for (PlayerIterator it = new PlayerIterator(players); it.hasNext();) {
            st = it.next();
            nm = st.getName();
            if(nm.equals(name)){
              exit = 1;
                break;
            }
        }

        if(exit == 1){
            return st;
        }
        else{
            return null;
        }
    }
    
    public void removeEmployee(){
        String saux;
        System.out.println("[+] Digite o nome do empregado a ser removido:");
        saux = utls.read.nextLine();
        
        Employee foundEmployee = findEmployee(saux);
        
        if(foundEmployee != null){
            if(foundEmployee.getFunction().equals("Jogador")){
                players.remove(foundEmployee);
                employees.remove(foundEmployee);
            }else if(foundEmployee.getFunction().equals("Presidente")){
                president =  emptyPosition;
                employees.remove(foundEmployee);
            }else if(foundEmployee.getFunction().equals("Treinador")){
                mainCoach = emptyPosition;
                employees.remove(foundEmployee);
            }else{
                employees.remove(foundEmployee);
            }
        }else{
            System.out.println("[!] ERRO: Empregado não encontrado!");
        }
        System.out.println("[!] Empregado removido com sucesso!");
    }
    
    public void searchEmployee(){
        String saux;
        System.out.println("[+] Digite o nome do empregado a ser buscado:");
        saux = utls.read.nextLine();
        
        Employee foundEmployee = findEmployee(saux);
        
        if(foundEmployee != null)
        {
            System.out.println("        [!] Nome: "+foundEmployee.getName());
            System.out.println("        [!] Email: "+foundEmployee.getEmail());
            System.out.println("        [!] CPF: "+foundEmployee.getCpf()+" Telefone: "+foundEmployee.getPhone());
            System.out.println("        [!] Salário: "+foundEmployee.getSalary());
            System.out.println("        [!] Função: "+foundEmployee.getFunction());
        }else{
            System.out.println("[!] ERRO: Empregado não encontrado!");
        }
        
    }
    
    public void searchPartner(){
        String name;
        System.out.println("[+] Digite o nome do sócio-torcedor:");
        name = utls.read.nextLine();
        
        Partner foundPartner = findPartner(name);
        
        if(foundPartner!=null){
            System.out.println("        [!] Nome: " + foundPartner.getName());
            System.out.println("        [!] Email: "+ foundPartner.getEmail()+" [!] CPF: "+foundPartner.getCpf());
            System.out.println("        [!] Telefone: "+foundPartner.getPhone()+" [!] Contribuição: "+foundPartner.getContribution());
            
            if(foundPartner.isCompliance()){
                System.out.println("        [!] Adimplência: Adimplente");
            }else{
                System.out.println("        [!] Adimplência: Inadimplente");
            }
            
            switch(foundPartner.getType()){
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
            
        }else{
            System.out.println("[!] ERRO: Sócio-torcedor não encontrado!");
        }
    }
    
    public void changeAvailability(){
        int code;
        
        System.out.println("[!] Digite o código do recurso: ");
        code = utls.readNumber();
        
        Resource foundResource = findResource(code);
        
        if(foundResource != null){
            if(foundResource.isAvailable()){
                System.out.println("[!] O status do recurso será alterado para INDISPONÍVEL!");
                foundResource.setAvailable(false);
            }else{
                System.out.println("[!] O status do recurso será alterado para DISPONÍVEL!");
                foundResource.setAvailable(true);
            }
        }else{
            System.out.println("[!] ERRO: Recurso não encontrado!");
        }
        
    }    
        
    public  void increaseStadium(){
        int code;
        int newCap;
        System.out.println("[+] Digite o código do estádio:");
        code = utls.readNumber();
        
        Stadium foundStadium = (Stadium) findResource(code);
        
        if(foundStadium != null){
            foundStadium.changeCapacity();
            System.out.println("[!] Capacidade alterada com sucesso!");
        }else{
            System.out.println("[!] ERRO: Estádio não encontrado!");
        }          
    }
    
    public  void increaseBathrooms(){
        int code;
        int newCap;
        System.out.println("[+] Digite o código do estádio:");
        code = utls.readNumber();
        
        Stadium foundStadium = (Stadium) findResource(code);
        
        if(foundStadium != null){
            foundStadium.changeBathrooms();
            System.out.println("[!] Banheiros adicionados com sucesso!");
        }else{
            System.out.println("[!] ERRO: Estádio não encontrado!");
        }          
    }
    
    public  void increaseSnackBars(){
        int code;
        int newCap;
        System.out.println("[+] Digite o código do estádio:");
        code = utls.readNumber();
        
        Stadium foundStadium = (Stadium) findResource(code);
        
        if(foundStadium != null){
            foundStadium.changeSnackBars();
            System.out.println("[!] Lanchonetes adicionadas com sucesso!");
        }else{
            System.out.println("[!] ERRO: Estádio não encontrado!");
        }          
    }
        
    public void changeHealthyStatus(){
        String saux;
        System.out.println("[+] Digite o nome do jogador a ter o status de saúde alterado:");
        saux = utls.read.nextLine();
        
        Player foundEmployee = findPlayer(saux);
        
        if(foundEmployee != null){
            if(foundEmployee.isHealthy()){
                System.out.println("[!] O jogador está registrado como APTO a jogar, será alterado para INAPTO!");
                foundEmployee.setHealthy(false);
                System.out.println("[!] O status de saúde do jogador agora é INAPTO!");
            }else{
                System.out.println("[!] O jogador está registrado como INAPTO a jogar, será alterado para APTO!");
                foundEmployee.setHealthy(true);
                System.out.println("[!] O status de saúde do jogador agora é APTO!");
            }
        }else{
            System.out.println("[!] ERRO: Jogador não encontrado!");
        }
    }
    
    public void changeCompliance(){
        String name;
        System.out.println("[+] Digite o nome do sócio-torcedor:");
        name = utls.read.nextLine();
        Partner foundPartner = findPartner(name);
        
        if(foundPartner!=null){
            if(foundPartner.isCompliance()){
                foundPartner.setCompliance(false);
                System.out.println("[!] Status de adimplência alterado para INADIMPLENTE!");
            }else{
                foundPartner.setCompliance(true);
                System.out.println("[!] Status de adimplência alterado para ADIMPLENTE!");
            }
        }else{
            System.out.println("[!] ERRO: Sócio-torcedor não encontrado!");
        }
    }
    
    public void menuAddEmployee(){
        int menuOpt = -1;
        String saux;
        Person p;
        
        
        while(menuOpt != 0){
            utls.showAddEmployeeMenu();
            menuOpt = utls.readNumber();
            saux = utls.read.nextLine();
            
            switch(menuOpt){
                case 1:
                    addPlayer();
                    break;
                case 2:
                    addCoach();
                    break;
                case 3:
                    addPresident();
                    break;
                case 4:
                    p = new Doctor();
                    addEmployee(p);
                    break;
                case 5:
                    p = new PersonalTrainer();
                    addEmployee(p);
                    break;  
                case 6:
                    p = new Lawyer();
                    addEmployee(p);
                    break;
                case 7:
                    p = new Cooker();
                    addEmployee(p);
                    break;
                case 8:
                    p = new Driver();
                    addEmployee(p);
                    break;      
            }
        }     
    }
    
    Resource findResource(int code){
        int nm;
        Resource st = null;
        int exit = 0;

        for (ResourceIterator it = new ResourceIterator(resources); it.hasNext();) {
        st = it.next();
            nm = st.getCode();
            if(nm == code){
                exit = 1;
                break;
            }
        }

        if(exit == 1){
            return st;
        }
        else{
            return null;
        }
    } 
    
    Employee findEmployee(String name){
        String nm;
        Employee st = null;
        int exit = 0;

        for (EmployeeIterator it = new EmployeeIterator(employees); it.hasNext();) {
        st = it.next();
            nm = st.getName();
            if(nm.equals(name)){
                exit = 1;
                break;
            }
        }

        if(exit == 1){
            return st;
        }
        else{
            return null;
        }
    }  
    
    Partner findPartner(String name){
        String nm;
        Partner st = null;
        int exit = 0;

        for (PartnerIterator it = new PartnerIterator(partners); it.hasNext();) {
        st = it.next();
            nm = st.getName();
            if(nm.equals(name)){
                exit = 1;
                break;
            }
        }

        if(exit == 1){
            return st;
        }
        else{
            return null;
        }
    }
}
