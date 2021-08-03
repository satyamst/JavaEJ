
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

 PrintWriter out = response.getWriter();
 String id = request.getParameter("txtUid");
 String ps = request.getParameter("txtPass");
 String em = request.getParameter("txtEmail");
 String co = request.getParameter("txtCon");
 try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection con =DriverManager.getConnection("jdbc:mysql://192.168.119.129:3306/Login_Db?useSSL=false","satyam","password");
 PreparedStatement pst = con.prepareStatement("insert into usr values(?,?,?,?)");
 pst.setString(1,id);
 pst.setString(2,ps);
 pst.setString(3,em);
 pst.setString(4,co);
 int row = pst.executeUpdate();
 out.println("<h1>"+row+ " Inserted Succesfullyyyyy");
 }catch(Exception e){out.println(e);}
}
}