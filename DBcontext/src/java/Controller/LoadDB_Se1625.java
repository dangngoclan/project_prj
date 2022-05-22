/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAO;
import Model.Department;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * @author pc
 */
public class LoadDB_Se1625 extends HttpServlet {

    DAO dao;

    @Override
    public void init() {
        dao = new DAO();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String departId = request.getParameter("departId");
        boolean gender = request.getParameter("gender").equals("m");
        float gpa = Float.parseFloat(request.getParameter("gpa"));
        String add = request.getParameter("add");
        dao.Insert(id,name,departId,gender,gpa,add);
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoadDB_Se1625</title>");
            out.println("<link href='CSS/style.css' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadDB_Se1625 at " + request.getContextPath() + "</h1>");
            dao.loadStudent();
            dao.loadDepart();
            String s = "<table>";
            for (Student obj : dao.getStdList()) {
                String id = obj.getDeptId();
                Department de = dao.getDepartHm().get(id);
                String departName = de.getName();
                s += obj.toRow(departName);
            }
            s += "</table>";
            out.println(s);
            String f = "<form action method = 'post'>";
            f += "ID: <input type='text' name='id'><br/>";
            f += "Name: <input type='text' name='name'><br/>";
            f += "Department: <input type='text' name='id'><br/>";
            for (Map.Entry<String,Department> en: dao.getDepartHm().entrySet()) {
                String key = en.getKey();
                Department value = en.getValue();
                f+="<option value = '"+key+"'>"+value.getName()+"</option>";
            }
            f += "Gender: <input type='radio' name='gender' value='m' checked> Male";
            f += "<input type='radio' name='gender' value='f'> Female <br/>";
            f += "GPA: <input type='text' name='gpa'><br/>";
            f+="Address: <input type='text' name='add'><br/>";
            f+="<input type='submit' value='Insert'><br/>";
            f+="</form>";
            out.println(f);
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
