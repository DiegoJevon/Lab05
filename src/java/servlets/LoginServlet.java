
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AccountService;

/**
 *  
 * @author Diego Maia
 */
public class LoginServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
    HttpSession session = request.getSession();
    
    
    if(request.getParameter("logout") != null){
        session.invalidate();
        request.setAttribute("message","You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    return;
    }
    
    
    String username = (String) session.getAttribute("username");
    
    if (username != null){
        response.sendRedirect("home");
    return;
    }
    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    return;

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       

                  
        
        if (username.isEmpty() && password.isEmpty()){
            session.setAttribute("message","Username and/or password must be filled.");
            session.setAttribute("username", username);
            session.setAttribute("password", password);  
            response.sendRedirect("login");            
            return;
        }

        
        AccountService checkAccountService = new AccountService();
               
        if (checkAccountService.login(username, password) != null){
            session.setAttribute("username", username);
            response.sendRedirect("home");
            return;
        }else{
           
           session.setAttribute("message","Invalid username and/or password.");
            request.setAttribute("username", username);  
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            return;
        }
        
    }

}
