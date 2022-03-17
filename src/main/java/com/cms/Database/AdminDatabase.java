
package com.cms.Database;

import com.cms.entities.User;
import com.cms.entities.admin;

import java.sql.*;

public class AdminDatabase {
    Connection con ;

    public AdminDatabase(Connection con) {
        this.con = con;
    }
    //for register user 
    
    public admin login(String id, String password){
    	admin ad=null;
        try{
        	  String query ="select * from adminData where Id=? and password=?";
              PreparedStatement pst = this.con.prepareStatement(query);
              pst.setString(1, id);
              pst.setString(2, password);
              ResultSet rs = pst.executeQuery();
            if(rs.next()){
            	
               ad= new admin();
               ad.setId(rs.getString("id")); 
               ad.setName(rs.getString("name"));
               ad.setPassword(rs.getString("password"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return ad;
    }
}