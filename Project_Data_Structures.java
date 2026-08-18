
package project_data_structures;

import javax.swing.*;
import java.util.*;

public class Project_Data_Structures {
 private static  Node head;
 
//********************************************************************
 private class Node{
    private int ID_Employee;
    private String name_Employee,phone_Number,address,First_day;
    private double Work_hours,salary; 
    private Node next;
    
    //here constructor of class Node
    public Node(int ID,String name,String day,String phone_Number,
            String address,double hours,double salary){
        this.ID_Employee=ID;
        this.name_Employee=name;
        this.First_day=day;
        this.phone_Number=phone_Number;
        this.address=address;
        this.Work_hours=hours;
        this.salary=salary;
        this.next=null;
        }         
 }// class Node
 
 //********************************************************************
    public void insert_Reecord(int ID,String name,String first_day,
         String phone_number,String address,double worke_hours,double salary){
       
       Node new_Employee=new Node(ID,name,first_day,phone_number,address,worke_hours,salary);
       if(head==null||head.ID_Employee>new_Employee.ID_Employee){
            new_Employee.next=head;
            head=new_Employee;
            return;
        }
        
       Node temp=head;
        while(temp.next!=null&&temp.next.ID_Employee<new_Employee.ID_Employee){
            temp=temp.next;
        }
        new_Employee.next=temp.next;
        temp.next=new_Employee;

     
    }//End insert_Reecord Method
    
//********************************************************************
    public boolean cheack_Record(int id){
        Node temp=head;
        if(head==null){
            return false;       
        }
        while(temp!=null){
            if(temp.ID_Employee==id){
                return true;}
              temp=temp.next;
        }return false;
        
    }//End cheack_Record Method
    
//********************************************************************
        public void SearchRecord(int id){
        if(!cheack_Record(id)){
            JOptionPane.showMessageDialog(null,"No records available..!");
        }else {
            Node temp = head;
            while (temp!=null){
            if(temp.ID_Employee == id){
            JOptionPane.showMessageDialog(null,"Employee Info :\n- ID:"+temp.ID_Employee
                    +"\n- Name:"+temp.name_Employee
                    +"\n- First day of work: "+temp.First_day
                    +"\n- Phone number: "+temp.phone_Number
                    +"\n- Address :"+temp.address
                    +"\n- Work hours: "+temp.Work_hours
                    +"\n- Salary: "+temp.salary);
                    break;
                }
                temp=temp.next;
            }


        }
    }//End SearchRecord Method
        
//********************************************************************
    public int delet_Record(int ID){
        
       if(!cheack_Record(ID)){
        JOptionPane.showMessageDialog(null,"No records available..!");    
        }
        Node temp=head,tail=null;
        if(temp!=null&&temp.ID_Employee==ID){
            head=head.next;
            return 0;
        }
        while (temp!=null&&temp.ID_Employee!=ID)
        {
            tail=temp;
            temp=temp.next;
        }
        if(temp==null){
        
            return -1;    
        }
        tail.next=temp.next;
      
        return 0;
        
    }//End delet_Record Method
    
//********************************************************************   
    public void showRecord(){
        Node temp=head;
        String output="";
        if(temp==null){
            JOptionPane.showMessageDialog(null, "No records available..!");
            return;
        }
        while(temp!=null){
            String data="Employee Info :\n- ID:"+temp.ID_Employee+
                    "\n- Name:"+temp.name_Employee+
                    "\n- First day of work: "+temp.First_day
                   +"\n- Phone number: "+temp.phone_Number+
                    "\n- Address :"+temp.address+
                    "\n- Work hours: "+temp.Work_hours
                   +"\n- Salary: "+temp.salary+
                    "\n*************************************************\n"; 
                
            temp=temp.next;
            output=output+"\n"+data;
        }
            JOptionPane.showMessageDialog(null, output );    
    }// End showRecord Method 
    
//********************************************************************
        public void UpdateRecord(int id){
        if(!cheack_Record(id)){
            JOptionPane.showMessageDialog(null,"No records available..!");
        }else {

            Node temp = head;
            while (temp!=null){
                if(temp.ID_Employee == id){
                    char character = 0;
               do{       
                    String list=JOptionPane.showInputDialog("Choose what you want to update:\n"
                            + "1-Name\n"
                            + "2-phone Number\n"
                            + "3-work Hourse\n"
                            + "4-salary\n"
                            + "5-address\n"
                            + "6-First day of work\n"
                            + "Enter your choice:" );
                                     
                     int choice= Integer.parseInt(list);
                     
                     switch(choice){
                         
                    case 1: 
                    String input = JOptionPane.showInputDialog("enter your name");
                    temp.name_Employee = input;
                    break;
                    
                    case 2:
                      input=  JOptionPane.showInputDialog("Enter your phone");
                    temp.phone_Number = input;
                    break;
                    
                    case 3:
                        
                     input=  JOptionPane.showInputDialog("Enter your work hourse\n"
                             + "\" grether than or equale 32 hourse\"");
                     double number = Double.parseDouble(input);
                     temp.Work_hours =number;
                      updateSalary(id);  
                    break;

   
                    case 4: 
                    input = JOptionPane.showInputDialog(" Enter your salary");
                    number= Double.parseDouble(input);
                    temp.salary=number;
                    break;
                    
                    case 5:             
                    input =JOptionPane.showInputDialog("Enter your address: ");
                     temp.address = input;
                     break;
                     
                    case 6:
                    input=JOptionPane.showInputDialog("Enter your first day: ");
                    temp.First_day = input;
                    break;
                    
                   default: 
                     JOptionPane.showMessageDialog(null,"Error selection");
                    
                     }
                     list=JOptionPane.showInputDialog( "Do you want to reselect?Y/N");
                      character=list.charAt(0);
                     }while(character=='Y'||character=='y');
                     
                     
                     
                }
                temp=temp.next;
            }


        }
    }// End UpdateRecord Method 
        
//********************************************************************
     public void updateSalary(int id) {
    Node temp = head;
  
    while (temp != null) {
        if (temp.ID_Employee == id) {
            if (temp.Work_hours > 32) {
                double hours = temp.Work_hours - 32;
                temp.salary += (temp.salary * 0.02) * hours; 
                
            }
        }
        temp = temp.next;
    }

}//End Updet Salary Method

    
    
//******************************************************************** 
    public static void main(String[] args) {
        // TODO code application logic here
       Project_Data_Structures project=new Project_Data_Structures ();
       JOptionPane.showMessageDialog(null,"**Welcome to Employed Record Management System**\n" );
       char character;
       String input;
       
       do{       
      String list= JOptionPane.showInputDialog( " **Please choose from the list** \n\n"
               + "1-Insert Employee Record\n"
               + "2-Delet Employee Record\n"
               + "3-Update Employee Record\n"
               + "4-Show details of an employee\n"
               + "5-Search an Employee Record\n"
               + "6-Exit\n"
               + "Select your Choice:");
       
           int choice= Integer.parseInt(list);
            boolean flag=false;
          
            switch(choice){
         
               case 1: //Insert Employee Record
                   
                   input =  JOptionPane.showInputDialog("Enter your ID ,in range 150 to 250");
                   int id = Integer.parseInt(input);
                   //validation for id
                   while(!flag){
                   if(id>=150&&id<=250){
                     flag=true;
                    }else{
                     input= JOptionPane.showInputDialog("wrong ,agin enter ID in range 150 to 250");
                     id = Integer.parseInt(input);
                     }
                   }      
                   if( !project.cheack_Record(id)){ //                      
                   String name = JOptionPane.showInputDialog("Enter your name");
                   String phone  =  JOptionPane.showInputDialog("Enter your phone");
                   input =  JOptionPane.showInputDialog("Enter your Salary");
                   double salary = Integer.parseInt(input);
                   double work_hours;
                    
                   input =  JOptionPane.showInputDialog("Enter your work_hours\n"
                           + "\" grether than or equale 32 hourse\"");
                   work_hours = Double.parseDouble(input);
                    
                   flag=false;
                   while(!flag){//validation Work Hourse
                       if(work_hours>32.0||work_hours==32.0){
                       flag=true;   
                       }else{
                        input =  JOptionPane.showInputDialog("wrong,Enter your work hours again\n"
                           + "\" grether than or equale 32 hourse\"");
                    work_hours = Double.parseDouble(input);
                       }
    
                   }
                   
                   String address = JOptionPane.showInputDialog("Enter your address");
                   String First_day = JOptionPane.showInputDialog( "Enter your first day:");
                   //creat record
                   project.insert_Reecord(id,name,First_day,phone,address,work_hours,salary);
                   project.updateSalary(id);
                    JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
                    
                   }else{
                       JOptionPane.showMessageDialog(null, "Employee already exist ");
                   }
                   break;
                   
     
               case 2:
                    input =  JOptionPane.showInputDialog("Enter your ID");
                    id = Integer.parseInt(input);
                  if(project.delet_Record(id)==0) {
                    JOptionPane.showMessageDialog(null," Record Deleted Successfully\n");
                       }
                 
                   break;
                   
               case 3:
                                      
                  input =  JOptionPane.showInputDialog("Enter your ID ");
                   id = Integer.parseInt(input);
                   project.UpdateRecord(id);
                   break;
                   
               case 4:
                   project.showRecord();
                   break;
                   
               case 5:
                   input =  JOptionPane.showInputDialog("Enter your ID");
                   id = Integer.parseInt(input);
                   project.SearchRecord(id);
                   break;
                   

               case 6:
                   JOptionPane.showMessageDialog(null, "Thank you for using the system ");
                   System.exit(0); 
                   
           default:
               JOptionPane.showMessageDialog(null, " error, please select again");
                list= JOptionPane.showInputDialog( " **Please choose from the list** \n\n"
               + "1-Insert Employee Record\n"
               + "2-Delet Employee Record\n"
               + "3-Update Employee Record\n"
               + "4-Show details of an employee\n"
               + "5-Search an Employee Record\n"
               + "6-Exit\n"
               + "Select your Choice:");
               break;
              }
           
        
       
           input=JOptionPane.showInputDialog("Do you want another operation? if yes press Y if No press N");
           character=input.charAt(0);
       }while(character=='Y'||character=='y');
                                                                                         
    }//End main method 
           
    
  }

