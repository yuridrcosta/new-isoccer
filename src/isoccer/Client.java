package isoccer;

public class Client {
    
    public static RegistersSingleton registers;
    public static UtilitySingleton utils;
    
    public static void main(String[] args) {
        registers = RegistersSingleton.getInstance();
        utils = UtilitySingleton.getInstance();
        showLogin();
    }
    
    public static void showLogin(){
        String saux;
        System.out.println("[+] Bem-vindo ao iSoccer - gerenciador de times de futebol!");
        System.out.println("[+] Digite o login do sistema:");
        saux = utils.read.nextLine();
        if(saux.equals("admin")){
            System.out.println("[+] Digite a senha do sistema:");
            saux = utils.read.nextLine();
            if(saux.equals("admin")){
                mainMenu();
            }
            else{
                System.out.println("[!] ERRO: A senha não corresponde!");
            }
        }else{
            System.out.println("[!] ERRO: Login não encontrado!");
        }
    }
    
    public static void mainMenu(){
        int menuOpt = -1;
        String saux;
        
        while(menuOpt != 0){
            utils.showMainMenu();
            menuOpt = utils.readNumber();
            saux = utils.read.nextLine();
            
            switch(menuOpt){
                case 1:
                    manageEmployees();
                    break;
                case 2:
                    manageResources();
                    break;
                case 3:
                    managePartners();
                    break;
                case 4:
                    reports();
                    break;
            }
            
        }
        
    }
    
    public static void manageEmployees(){
        int menuOpt = -1;
        String saux;
        
        while(menuOpt != 0){
            utils.showEmployeesMenu();
            menuOpt = utils.readNumber();
            saux = utils.read.nextLine();
            
            switch(menuOpt){
                case 1:
                    registers.menuAddEmployee();
                    break;
                case 2:
                    registers.removeEmployee();
                    break;
                case 3:
                    registers.searchEmployee();
                    break;
                case 4:
                    registers.changeHealthyStatus();
                    break;
            }         
        }  
    }
    
    public static void manageResources(){
        int menuOpt = -1;
        String saux;
        Resource res;
        
        utils.showManageResourcesMenu();
        menuOpt = utils.readNumber();
        
        switch(menuOpt){
            case 1:
                res = new Stadium();
                registers.addResource(res);
                break;
            case 2:
                res = new TrainingCenter();
                registers.addResource(res);
                break;
            case 3:
                res = new Bus();
                registers.addResource(res);
                break;
            case 4:
                utils.listResources();
                break;
            case 5:
                registers.increaseStadium();
                break;
            case 6:
                registers.increaseSnackBars();
                break;
            case 7:
                registers.increaseBathrooms();
                break;
            case 8:
                registers.changeAvailability();
                
        }
    }
    
    public static void managePartners(){
        int menuOpt;
        String saux;
        
        utils.showManagePartnersMenu();
        menuOpt = utils.readNumber();
        saux = utils.read.nextLine();
        
        switch(menuOpt){
            case 1:
                registers.addPartner();
                break;
            case 2:
                registers.searchPartner();
                break;
            case 3:
                registers.changeCompliance();
                break;
            default:
                System.out.println("[!] ERRO: Número de opção incorreto");
                break;
        }
    }
    
    public static void reports(){
        int menuOpt;
        String saux;
        
        utils.showReportsMenu();
        menuOpt = utils.readNumber();
        saux = utils.read.nextLine();
        
        switch(menuOpt){
            case 1:
                utils.employeesReport();
                utils.listResources();
                System.out.println("[!] Número de sócios: "+ registers.partners.size());
                utils.listPartners();
                break;
            case 2:
                utils.employeesReport();
                break;
            case 3:
                utils.listResources();
                break;
            case 4:
                System.out.println("[!] Número de sócios: "+registers.partners.size());
                utils.listPartners();
                break;
        }
    }
}