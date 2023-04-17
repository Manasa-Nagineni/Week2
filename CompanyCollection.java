import java.util.*;

public class CompanyCollection {


    static void addEmployee(HashMap hm , Integer id , String name, String date,  String type , String role , String status){
        LinkedList ll = new LinkedList();
        ll.add(name);
        ll.add(date);
        ll.add(type);
        ll.add(role);
        ll.add(status);
        if(hm.putIfAbsent(id,ll)==null){
            System.out.println("User added successfully");
        }else{
            System.out.println("employee with the id already exists ");x
        }
    }

    public static void main(String args[]){
        HashMap<Integer,LinkedList> hm = new HashMap<Integer,LinkedList>();
        addEmployee(hm, 123,"ksds","kugdi","lwhdiugw","kugaid","jygd");
        addEmployee(hm, 124,"kss","kugdi","lwhdiugw","kugaid","jygd");
        
        System.out.println(hm);

        
    }
    
}
