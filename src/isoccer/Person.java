/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isoccer;

public class Person implements PersonStrategy{
    
    UtilitySingleton utils = UtilitySingleton.getInstance();
    private String name;
    private String email;
    private String cpf;
    private int phone;

    public Person() {
    }

    public Person(String name, String email, String cpf, int phone) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
    }
        
    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }    
    
    @Override
    public void createPerson() {
        getBaseData();
    }
    
    
    public void getBaseData(){
        System.out.println("[+] Digite o nome:");
        this.name = utils.read.nextLine();
        System.out.println("[+] Digite o email:");
        this.email = utils.read.nextLine();
        System.out.println("[+] Digite o cpf:");
        this.cpf = utils.read.nextLine();
        System.out.println("[+] Digite o telefone: (SOMENTE NÚMEROS)");
        this.phone = utils.readNumber();
    }
    
}
