package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1) invalidate session nếu có
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            getServletContext().log("Session invalidated in LogoutServlet.");
        } else {
            getServletContext().log("No session to invalidate in LogoutServlet.");
        }

        // 2) Không xóa cookie (theo yêu cầu) — cookie userC/passC sẽ vẫn tồn tại
        // Nếu bạn muốn xóa cookie ở tương lai, thêm code xóa vào đây.

        // 3) Forward tới logout.jsp (màu mè). Nếu bạn muốn redirect sang /login, thay bằng sendRedirect.
        req.setAttribute("loginUrl", req.getContextPath() + "/login");
        req.getRequestDispatcher("/WEB-INF/auth/logout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
