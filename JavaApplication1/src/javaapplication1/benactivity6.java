/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author AICS-CEBU
 */
import java.sql.*;
import java.util.*;
public class benactivity6 {

    /**
     * @param args the command line arguments
     */
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("ID");
        int uid = in.nextInt();
        System.out.println("Enter Username: ");
        String username = in.next();
        System.out.println("Enter Amount: ");
        double amount = in.nextDouble();
        System.out.println("Enter Quantity: ");
        int quantity = in.nextInt();
        System.out.println("Enter Cash: ");
        double cash = in.nextDouble();
        double total = amount * quantity;
        double changed = cash - total;
        insert(uid, username, amount, quantity, cash, total, changed); 
        
    }
     static void insert(int uid, String username, double amount, int quantity, double cash, double total, double changed){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbctest", "root", "");
        
        Statement st = con.createStatement();
        String sql = "insert into jdbctest values(" + uid + ",'" + username + "'," + amount + "," + quantity + "," + cash + "," + total + "," + changed + ")";
        
        st.executeUpdate(sql);
        con.close();
        }catch(Exception e) {System.out.print(e);}
    
    }
}
