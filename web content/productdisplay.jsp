<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="Styles/admin.css">  
        <link rel="stylesheet" href="Styles/view.css">  
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <link rel="stylesheet" href="Styles/carousel.css">

</head>
<body>
<form method ="post" action = "p3 "multipart/form-data">
<table>

       <tr>
                             
        <th>product id</th>
        <th>product image</th>
        <th>product name</th>
        <th>product code</th>
        <th>product price</th>
        <th>product description</th>
        <th>options</th>
         </tr>
		
		<%
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/product";
				String username="root";
				String password="it21226632";
				String query="select * from product";
				Connection conn=DriverManager.getConnection(url, username, password);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
			{

		%>

	<tr><td><%=rs.getInt("ProductID") %></td>
	<td><img src="DisplayImage?ProductID=ProductImage" class="product-img"/></td>
	<td><%=rs.getString("ProductName")%></td>
	<td><%=rs.getString("ProductPrice") %></td>
	<td><%=rs.getString("ProductCode") %></td>
	<td><%=rs.getString("ProductDescription") %></td></tr>

 <%

}
%>
</table>
<%
rs.close();
stmt.close();
conn.close();
}
catch(Exception e)
{
e.printStackTrace();
}
%>
</form>
<script>
            jQuery(document).ready(function(){
                jQuery('.titleWrapper').click(function(){
                    var toggle = jQuery(this).next('div#descwrapper');
                    jQuery(toggle).slideToggle("slow");
                });
                jQuery('.inactive').click(function(){
                    jQuery(this).toggleClass('inactive active');
                });
            });

        </script>
</body>
</html>