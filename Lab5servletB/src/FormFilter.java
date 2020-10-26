import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FormFilter")
public class FormFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phoneno = request.getParameter("phoneno");
        String Address1 = request.getParameter("Address1");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");

        boolean valid = EmailValidator.getInstance().isValid(email);

        if (firstname == null || "".equals(firstname)
                ||  email == null || "".equals(email) || lastname==null || "".equals(lastname)
                || Address1==null || "".equals(Address1)
                || city==null || "".equals(city)
                || state==null || "".equals(state)
                || zipcode==null || "".equals(zipcode)) {

            request.setAttribute("errMsg", " fields are empty");


        }
        else if (!valid) {

            request.setAttribute("errMsg", "Email format not valid");

        }
        else {

            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
