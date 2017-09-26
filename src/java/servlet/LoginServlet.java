/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domainClasses.user;
import domainClasses.userServices;

/**
 *
 * @author 686623
 */
public class LoginServlet extends HttpServlet {
   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logoutMessage = request.getParameter("message");
        request.setAttribute("message",logoutMessage);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        
        
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("uName");
        String passWord = request.getParameter("pWord");
        
        userServices uS = new userServices();
        
        user u = new user();
        u.setUsername(request.getParameter("uName"));
        u.setPassword(request.getParameter("pWord"));
       
     //   request.setAttribute("username", u.getUsername());
     //   request.setAttribute("password", u.getPassword());
     request.setAttribute("user", u);
        
   
     
     if( uS.login(u) == true)
        {
           
           request.setAttribute("helloMessage", "Hello, " + userName );
         getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);  
                
        }
        else
        {
            
         request.setAttribute(userName, userName);
         request.setAttribute("password", passWord);
         request.setAttribute("errorMessage", "Invalid username or password");
         getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); 
        }
        
    }
    }

