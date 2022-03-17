
package com.cms.helper;

public class DescriptionHelper {
    public static String getdesc3(String desc){
        
        String str[] = desc.split(" ");
        
        if(str.length>3){
            String res="";
            for (int i=0;i<3;i++){
                res=res+str[i];
            }
            return (desc+"...");
            
        }
        else{
            
            return (desc+"...");
        }
    }
    
}
