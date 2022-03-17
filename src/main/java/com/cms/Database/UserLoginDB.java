
package com.cms.Database;

import com.cms.entities.CategoryData;
import com.cms.entities.User;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserLoginDB {
    
    Connection con;

    public UserLoginDB(Connection con) {
        this.con = con;
    }  
    
    public User login(String prn , String password) {
        User user= null;
         try{
            String query ="select * from StudentData where Prn=? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, prn);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
               user = new User();
                System.out.println(rs.getString("name"));
                user.setName(rs.getString("name"));
                user.setPrn(rs.getString("prn"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                user.setBranch(rs.getString("branch"));
               
                user.setPassword(rs.getString("password"));
        
                    
                user.setName(rs.getString("Successful"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
    public List<User>getUser() throws SQLException{
        
           ArrayList<User> list=new ArrayList<User>();
        
        try {
           
             String q="Select * from userregister";
            PreparedStatement pst = this.con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                User u= new User();
//                
               u.setPrn(rs.getString("Prn"));
               u.setName(rs.getString("name"));
               u.setBranch(rs.getString("branch"));
               u.setMobile(rs.getString("mobile"));
               u.setEmail(rs.getString("email"));
               
                list.add(u);
                
                
            }
             
             
        } catch (Exception ex) {
          out.println(ex);
        }
           
         return list;   
    
}
   
    }

