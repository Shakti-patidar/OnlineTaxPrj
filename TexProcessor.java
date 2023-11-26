
package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TexProcessor extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //read request data 
        String s1=request.getParameter("t1");
        String s2=request.getParameter("t2");
        String s[]=request.getParameterValues("t3");
        String s3=request.getParameter("c1");
        String s4=request.getParameter("r1");
        //process the data
        int tax=0;
        int income=Integer.parseInt(s1);
        int age=Integer.parseInt(s2);
        
        if(income>=500000){
           tax=income*20/100; 
        }
        else if(income>=300000){
            tax=income*10/100;
        }
        if(age>=60){
            tax=tax-(tax*10/100);
        }
        int srch=0;
        if(s!=null){
            srch=s.length*500;
        }
        int nricharges=0;
        if(s3!=null){
            nricharges=10000;
        }
        int ptax=0;
        if(s4.equals("service")){
            ptax=1000;
        }
        else if(s4.equals("business")){
            ptax=2000;
        }
        //provid the response
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Income Dept</h2>");
        out.println("<h3>Thanks for visiting us.</h3>");
        out.println("<table border=2>");
        out.println("<tr>");
        out.println("<td>Income</td>");
        out.println("<td>"+income+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Age</td>");
        out.println("<td>"+age+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Tax</td>");
        out.println("<td>"+tax+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Sur-Charges</td>");
        out.println("<td>"+srch+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>NRI-Charge</td>");
        out.println("<td>"+nricharges+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>prof-Tax</td>");
        out.println("<td>"+ptax+"</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<h3>Assets Declared by you:</h3>");
        out.println("<ol>");
        for(String tmp:s){
            out.println("<li>");
            out.println(tmp);
            out.println("</li>");
        }
        out.println("</ol>");
        out.println("<marquee>pay your taxes before 31st march.</marquee>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
