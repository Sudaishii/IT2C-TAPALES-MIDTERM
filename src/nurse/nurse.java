/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nurse;

import NurseApp.config;
import java.util.Scanner;

public class nurse {
      config conf = new config();
    public void addNurse(){
        
        Scanner sc = new Scanner(System.in);
      
        
        System.out.print("Nurse First Name: ");
        String fname = sc.next();
        System.out.print("Nurse Last Name: ");
        String lname = sc.next(); 
        System.out.print("Department: ");
        String dept = sc.next();
        System.out.print("Contact #: ");
        String pnumber = sc.next();
        System.out.print("Shift (Day/Night): ");
        String shift = sc.next();

        String sql = "INSERT INTO tbl_nurse (first_name, last_name, department, contact_number, shift) VALUES (?, ?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, dept, pnumber, shift);


    }
    
    
    private void viewNurse() {
        String votersQuery = "SELECT * FROM tbl_nurse";
        String[] votersHeaders = {"ID", "First Name", "Last Name", "Department", "Contact Number", "Shift (Day/Night)"};
        String[] votersColumns = {"nurse_id", "first_name", "last_name", "department", "contact_number", "shift"};

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    
    
    public void updateNurse(){
        
        Scanner oha = new Scanner(System.in);
        
        System.out.print("Enter the ID you want to Update: ");
        int id = oha.nextInt();
        
        System.out.print("Enter New Department: ");
        String dept = oha.next();
        
        System.out.print("Enter New Phone Number: ");
        String pnum = oha.next();
        
        System.out.print("Etner New Shift (Day/Night): ");
        String shift = oha.next();
        
        String sqlUpdate = "UPDATE tbl_nurse SET department = ?, contact_number = ?, shift = ? WHERE nurse_id = ?";
        conf.updateRecord(sqlUpdate, dept, pnum, shift, id);
    }
         
     public void deleteNurse(){
         Scanner oha = new Scanner(System.in);
        
        System.out.print("Enter the ID you want to Delete: ");
        int id = oha.nextInt();
        String sqlDelete = "DELETE FROM tbl_nurse WHERE nurse_id = ?";
        conf.deleteRecord(sqlDelete, id);
     }
    
    public static void Nurse(){
        
        Scanner sc = new Scanner(System.in);
        String res;
        nurse nrs = new nurse();
        
       do{
        
        System.out.println("Welcome to the System........");
        
        System.out.println("========================================");
        System.out.println("\t1. Add Nurse");
        System.out.println("\t2. View Nurse");
        System.out.println("\t3. Update Nurse Details");
        System.out.println("\t4. Delete Nurse");
        System.out.println("\t5. Exit..");
        System.out.println("========================================");
        
        System.out.print("Enter Action: ");
        int opt = sc.nextInt();
        
        switch(opt){
            
            case 1: 
                nrs.addNurse();
                break;
                
            case 2:
                nrs.viewNurse();
                break;
                
            case 3:
                nrs.viewNurse();
                nrs.updateNurse();
                nrs.viewNurse();
                break;
            case 4:
                nrs.viewNurse();
                nrs.deleteNurse();
                System.out.print("Deleted . . . . .\n");
                nrs.viewNurse();
                break;
            case 5:
                System.out.println("Exiting . . . .");
                System.out.println("Thank you for using the System!");
                System.exit(0);
                break;
            
            
        }
        
                System.out.print("Do you want to continue? (y/n): ");
                res = sc.next();
        
    }while(res.equals("Y") || res.equals("y"));
    
       
    }
}
