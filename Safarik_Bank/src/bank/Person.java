/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author David Šafařík
 */
public class Person extends Client{

    public Person(String first_name, String last_name) {
        super(first_name, last_name);
    }

    @Override
    public String getClientName() {
        String temp = "";
        temp += last_name.charAt(last_name.length()-3);
        temp += last_name.charAt(last_name.length()-2);
        temp += last_name.charAt(last_name.length()-1);
        String address;
        if ("ová".equals(temp) || "ova".equals(temp)){
            address = "paní";
        }else{
            address = "pan";
        }
        return  address + " " + first_name + " " + last_name;
    }
    
    public static void main(String [] args){
        Person klient1 = new Person("Karel", "Ptáček");
        Person klient2 = new Person("Pavla", "Kopejskova");
        System.out.println(klient1.getClientName());
        System.out.println(klient2.getClientName());
    }
    
}
