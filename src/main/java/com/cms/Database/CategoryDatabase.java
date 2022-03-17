
package com.cms.Database;
import com.cms.entities.CategoryData;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoryDatabase {
    Connection con;

    public CategoryDatabase(Connection con) {
        this.con = con;
    }
    
    public boolean catData(CategoryData catData){
        
        boolean set = false;
        try{
            
            
            String query = "insert into category (Category_Title,Category_Description,Images) values(?,?,?)";
            PreparedStatement pt = con.prepareStatement(query);
            
            
            pt.setString(1,catData.getTitle());
            pt.setString(2,catData.getDesc());
            pt.setString(3,catData.getImage());
            
            pt.executeUpdate();
           set = true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return set;
    }
    
    
    public List<CategoryData>getCategory() throws SQLException{
        
           List<CategoryData> list=new ArrayList<CategoryData>();
        
        try {
           
             String q="Select * from category";
            PreparedStatement pst = this.con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                CategoryData CData= new CategoryData();
//                
               
                CData.setId(rs.getString("ID"));
                CData.setTitle(rs.getString("Category_Title"));
                CData.setDesc(rs.getString("Category_Description"));
                CData.setImage(rs.getString("Images"));
                
                list.add(CData);
                
                
            }
             
             
        } catch (Exception ex) {
          out.println(ex);
        }
           
         return list;   
    
}
   
  
    
}
