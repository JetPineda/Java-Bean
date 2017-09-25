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
        
    
        UserService(request, response);
 
    }
    
    protected void UserService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String userName = request.getParameter("uName");
        String passWord = request.getParameter("pWord");
        request.setAttribute("username", userName);
        request.setAttribute("password", passWord);
        
        boolean valid = login(userName,passWord);
        
         if(valid == true)
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
    
    
    
    protected boolean login(String userName, String passWord){
        boolean valid = false;
        
        String validUserName1 = "adam";
        String validUserName2 = "betty";
        String validPassword = "password";
        
        if(userName.equalsIgnoreCase(validUserName1) && passWord.equalsIgnoreCase(validPassword)
                || userName.equalsIgnoreCase(validUserName2) && passWord.equalsIgnoreCase(validPassword))
        {
            
            return valid = true;
        }
        else
        {
            return valid;
        }
       
        
        
       
        
        
        
        
     
    }

    
   
}
