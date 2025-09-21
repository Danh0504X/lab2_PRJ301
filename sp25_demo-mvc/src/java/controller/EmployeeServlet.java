/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="EmployeeServlet", urlPatterns={"/employees"})
public class EmployeeServlet extends HttpServlet {
   private EmployeeService employeeService = new EmployeeServiceImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }  
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
            
        }
        
         switch (action) {
            case "create":
                createEmp(request, response);
                break;
            case "edit":
                editEmp(request, response);
                break;
            case "delete":
                deleteEmp(request, response);
                break;
            default:
                listEmployees(request, response);
                break;
        }
}
       


 
    @Override

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createEmp(request, response);
                break;
            case "edit":
                updateEmp(request, response);
                break;
            case "delete":
                deleteEmp(request, response);
                break;
            default:
                listEmployees(request, response);
                break;
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
 private void listEmployees(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            List<Employee> emplist = employeeService.findAll();
            request.setAttribute("employee", emplist);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/listEmp.jsp");
            dispatcher.forward(request, response);
    }

   private void createEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
    int id = (int)(Math.random()*1000);
    Employee emp = new Employee(id,
        request.getParameter("name"),
        request.getParameter("email"),
        request.getParameter("address"));
    employeeService.save(emp);
    response.sendRedirect(request.getContextPath() + "/employee/employees");
  }

   
   private void editEmp(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Lấy ID nhân viên cần chỉnh sửa từ request
    int id = Integer.parseInt(request.getParameter("id"));
    
    // Tìm nhân viên theo ID
    Employee employee = employeeService.findById(id);
    
    // Đưa thông tin nhân viên vào request để hiển thị trên form
    request.setAttribute("employee", employee);
    
    // Forward đến trang edit.jsp (form chỉnh sửa)
    RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/editEmp.jsp");
    dispatcher.forward(request, response);
}
   
   private void updateEmp(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    
    // Tạo đối tượng nhân viên với thông tin đã chỉnh sửa
    Employee emp = new Employee(id, name, email, address);
    
    // Cập nhật nhân viên
    employeeService.save(emp);
    
    // Redirect về danh sách nhân viên
    response.sendRedirect(request.getContextPath() + "/employee/employees");
}

   
   private void deleteEmp(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    
    // Xóa nhân viên theo ID
    employeeService.remove(id);
    
    // Redirect lại trang danh sách nhân viên
    response.sendRedirect(request.getContextPath() + "/employee/employees");
}
}

