import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBconnection db= new DBconnection();
        String fname= request.getParameter("fname");
        String lname= request.getParameter("lname");
        String phoneno= request.getParameter("phoneno");
        String Email= request.getParameter("Email");
        String Address1= request.getParameter("Address1");
        String Address2= request.getParameter("Address2");
        String city= request.getParameter("city");
        String state= request.getParameter("state");
        String zipcode= request.getParameter("zipcode");


        db.insertRecord(fname,lname,phoneno,Email,Address1,Address2,city,state,zipcode);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
