import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



class Employee {
    private int employeeId;
    private String employeeName;
    private Date joiningDate;
    private String employmentType;
    private String role;
    private String domain;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getJoiningDate(){
        return joiningDate;
    }

    public void setJoiningDate(Date joiningdate){
        this.joiningDate = joiningdate;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


}
        


public class FileCompany {

    //private static final String FILENAME = "employee_data.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private static List<Employee> employees = new ArrayList<>();

    private static void readDataFromFile() {
        try {
            FileReader fr = new FileReader("C:\\Users\\mannagin\\Desktop\\Grooming\\Week2\\employee_data.txt");  
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(";");
                Employee employee = new Employee();
                employee.setEmployeeId(Integer.parseInt(employeeData[0]));
                employee.setEmployeeName(employeeData[1]);
                try {
                    employee.setJoiningDate(DATE_FORMAT.parse(employeeData[2]));
                } catch (ParseException e) {
                    System.out.println("Error parsing date for employee " + employee.getEmployeeName());
                }
                employee.setEmploymentType(employeeData[3]);
                employee.setRole(employeeData[4]);
                employee.setDomain(employeeData[5]);
                employees.add(employee);
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    private static void displayEmployeeDetails(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                System.out.println("Employee Details:");
                System.out.println("ID: " + employee.getEmployeeId());
                System.out.println("Name: " + employee.getEmployeeName());
                System.out.println("Joining Date: " + DATE_FORMAT.format(employee.getJoiningDate()));
                System.out.println("Employment Type: " + employee.getEmploymentType());
                System.out.println("Role: " + employee.getRole());
                System.out.println("Domain: " + employee.getDomain());
                return;
            }
        }
        System.out.println("No employee found with ID " + employeeId);
    }

    private static void displayEmployeesByRole(String role) {
        System.out.println("Employees with Role " + role + ":");
        for (Employee employee : employees) {
            if (employee.getRole().equals(role)) {
                System.out.println(employee.getEmployeeName());
            }
        }
    }

    private static void displayEmployeesByExperience(int years) {
        System.out.println("Employees with " + years + " or more years of experience:");
        Date currentDate = new Date();
        for (Employee employee : employees) {
            long experience = currentDate.getTime() - employee.getJoiningDate().getTime();
            experience = experience / (1000L * 60L * 60L * 24L * 365L);
            if (experience >= years) {
                System.out.println(employee.getEmployeeName());
            }
        }
    }

    public static void main(String args[]){
        readDataFromFile();
        Scanner s = new Scanner(System.in);
        int exit = 1;
        while(exit != 0){
            System.out.println("************************\n Enter your option : \n 1.Display the employee details given employee Id \n 2.Display the list of employees given role \n 3.Display the list of employees having experience >= given minimum years of experience. \n 0.Exit ");
            int choice = s.nextInt();
            s.nextLine();
            switch(choice){
                case 1: 
                    System.out.println("Enter the employee id : ");
                    int i = s.nextInt();
                    s.nextLine();
                    displayEmployeeDetails(i);
                    break;
                case 2: 
                    System.out.println("Enter the employee id: ");
                    String str = s.nextLine();
                    displayEmployeesByRole(str);
                    break;
                case 3: 
                    System.out.println("Enter the minimum number of years :");
                    int j = s.nextInt();
                    displayEmployeesByExperience(j);
                    break;
                case 0: 
                    exit = 0;
                    break;
                default:
                    System.out.println("Enter proper option: ");

            }

        }
    }
}


