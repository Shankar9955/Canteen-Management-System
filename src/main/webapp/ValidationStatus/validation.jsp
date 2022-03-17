<%
    String massage = (String) session.getAttribute("massage");
    if(massage!=null){
    out.println(massage);
    session.removeAttribute("massage");
  
    }
%>