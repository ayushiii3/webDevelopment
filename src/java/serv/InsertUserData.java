/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author CIT
 */
@MultipartConfig(maxFileSize = 16177215) 
public class InsertUserData extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertUserData</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertUserData at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            System.out.println(request.getParameter("name"));
            System.out.println(request.getParameter("age"));
            System.out.println(request.getParameter("weight"));
            System.out.println(request.getParameter("emailId"));
            System.out.println(request.getParameter("healthReport"));
            float weight = Float.parseFloat(request.getParameter("weight"));
            String emailId = request.getParameter("emailId");
             InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("file");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
            //String healthReport = request.getParameter("healthReport");
            //FileItemFactory factory=new DiskFileItemFactory();
            //ServletFileUpload upload=new ServletFileUpload(factory);
            
            //Part part = request.getPart("healthReport");
            //String fileName= part.getSubmittedFileName();
            /* String healthReport = request.getParameter("healthReport");
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final InputStream in = new FileInputStream(healthReport);
            final byte[] buffer = new byte[500];

            int read = -1;
            while ((read = in.read(buffer)) > 0) {
                baos.write(buffer, 0, read);
            }
            
            in.close();
            byte[] arr=baos.toByteArray();
            */
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","ayushi");
                PreparedStatement p = con.prepareStatement("insert into user values(?,?,?,?,?)");
                p.setString(1,name);
                p.setInt(2, age);
                p.setFloat(3, weight);
                p.setString(4, emailId);
                if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                p.setBlob(5, inputStream);
            }
                p.executeUpdate();
                
                response.sendRedirect("Form.jsp");
                
            }catch(Exception e){
                e.printStackTrace();
            }
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
