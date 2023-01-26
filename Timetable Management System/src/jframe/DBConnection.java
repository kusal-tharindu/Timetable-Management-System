/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sunil
 */
public class DBConnection {
    
    public static void main(String args[]) {
        getConnection();
    }

   
    static Connection con = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooltimetable","root","");
            System.out.println("DataBase connected");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DataBase Disconnected");
        }
        return con;
    }

    
}


