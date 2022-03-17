/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionDataBase {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "rshankar", "radhe");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}

