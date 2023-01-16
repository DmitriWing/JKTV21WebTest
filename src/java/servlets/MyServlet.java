
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet", "/readers", "/books", "/home"})
public class MyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        switch(request.getServletPath()){       // getServletPath() - loking for in urlPatterns = {..., ..., }
            case "/readers":
                request.setAttribute("info", "This info transferred via servlet by pattern /readers");     // request.setAttribute("here variable which will be transferred to html", "here is a value of variable");
                request.setAttribute("title", "Readers");     // request.setAttribute("here variable which will be transferred to html", "here is a value of variable");
                request.getRequestDispatcher("/WEB-INF/readers.jsp").forward(request, response);
                break;
            case "/books":
                request.setAttribute("info", "This info transferred via servlet by pattern /books");     // request.setAttribute("here variable which will be transferred to html", "here is a value of variable");
                request.setAttribute("title", "Books");     // request.setAttribute("here variable which will be transferred to html", "here is a value of variable");
                request.getRequestDispatcher("/WEB-INF/books.jsp").forward(request, response);
                break;
            case "/home":
                request.setAttribute("info", "This info transferred via servlet by pattern /home");     // request.setAttribute("here variable which will be transferred to html", "here is a value of variable");
                request.setAttribute("title", "Library");     // request.setAttribute("here variable which will be transferred to html", "here is a value of variable");
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                break;
           
            case "/MyServlet":
                try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MyServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet MyServlet at " + request.getContextPath() + "</h1>");
                out.println("<h2>Query Pattern " + request.getQueryString() + "</h2>");
                out.println("</body>");
                out.println("</html>");
            }
                break;
//            case "/page3":
//                request.getRequestDispatcher("/WEB-INF/page3.html").forward(request, response);
//                break;
//            case "/pageJSP2":
//                request.setAttribute("info", "This info transferred from servlet");     // request.setAttribute("here variable which will be transferred to html", "here is a value of variable");
//                request.getRequestDispatcher("/WEB-INF/pageJSP2.jsp").forward(request, response);
//                break;
            default:
                throw new AssertionError();
            
        }
        
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
