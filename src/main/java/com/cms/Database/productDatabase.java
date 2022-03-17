package com.cms.Database;

import com.cms.entities.Cart;
import com.cms.entities.User;
import com.cms.entities.productData;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productDatabase extends User {
    
    Connection con;
    
    public productDatabase(Connection con) {
        this.con = con;
    }
    
    public boolean Product(productData pro) throws SQLException {
        boolean set = false;
        String q = "insert into products (Title,Description,Price,Image,Cid) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(q);
        
        try {
            
            pt.setString(1, pro.getTitle());
            pt.setString(2, pro.getDescription());
            pt.setInt(3, pro.getPrice());
            pt.setString(4, pro.getImage());
            pt.setString(5, pro.getCid());
            
            pt.executeUpdate();
            set = true;
            
        } catch (Exception ex) {
            out.println(ex);
        }
        
        return set;
    }
    
    public List<productData> getProduct() throws SQLException {
        
        List<productData> list = new ArrayList<productData>();
        
        try {
            
            String q = "Select * from products";
            PreparedStatement pst = this.con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                productData CData = new productData();
//                

                CData.setId(rs.getInt("ID"));
                CData.setTitle(rs.getString("Title"));
                CData.setDescription(rs.getString("Description"));
                CData.setPrice(rs.getInt("Price"));
                CData.setImage(rs.getString("Image"));
                CData.setCid(rs.getString("CID"));
                list.add(CData);
                
            }
            
        } catch (Exception ex) {
            out.println(ex);
        }
        
        return list;
    }
    
    public List<productData> getpoductById(String Cid) throws SQLException {
        
        List<productData> list = new ArrayList<productData>();
        
        try {
            
            String q = "Select * from products where CID=?";
            PreparedStatement pst = this.con.prepareStatement(q);
            pst.setString(1, Cid);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                productData p = new productData();
//                

                p.setId(rs.getInt("ID"));
                p.setTitle(rs.getString("Title"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getInt("Price"));
//                CData.setQuantity(rs.getInt("Quantity"));
                p.setImage(rs.getString("Image"));
                p.setCid(rs.getString("CID"));
                
                list.add(p);
                
            }
            
        } catch (Exception ex) {
            out.println(ex);
        }
        
        return list;
    }
    
    public ArrayList<Cart> getCartProduct(ArrayList<Cart> cartList) {
        ArrayList<Cart> products = new ArrayList<Cart>();
        try {
            
            if (cartList.size() > 0) {
                for (Cart items : cartList) {
                    String q = "Select * from products where ID=?";
                    PreparedStatement pst = this.con.prepareStatement(q);
                    pst.setInt(1, items.getId());
                    ResultSet rs = pst.executeQuery();
                    
                    while (rs.next()) {
                        Cart row = new Cart();
//                

                        row.setId(rs.getInt("ID"));
                        row.setTitle(rs.getString("Title"));
                        row.setDescription(rs.getString("Description"));
                        row.setPrice(rs.getInt("Price"));
                        row.setQuantity(items.getQuantity());
                        row.setImage(rs.getString("Image"));
                        row.setCid(rs.getString("CID"));
                        
                        products.add(row);
                        
                    }
                    
                }
            }            
        } catch (Exception e) {
            out.println(e);
        }
        
        return products;
    }
    
    public int getTotalPrice(ArrayList<Cart> cartList) {
        int sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String q = "Select * from products where ID=?";
                    PreparedStatement pst = this.con.prepareStatement(q);
                    pst.setInt(1, item.getId());
                    ResultSet rs = pst.executeQuery();
                    
                    while (rs.next()) {
                        sum += rs.getInt("Price") * item.getQuantity();
                    }
                    
                }
            }
            
        } catch (Exception e) {
            
        }
        return sum;
    }
    
}
