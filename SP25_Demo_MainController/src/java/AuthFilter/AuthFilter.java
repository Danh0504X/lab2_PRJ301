package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import model.User;
import java.io.IOException;
import java.util.Set;

@WebFilter("/*")
public class AuthFilter implements Filter {
    // public paths (cho phép truy cập mà không cần login)
    private static final Set<String> PUBLIC = Set.of(
        "/login", "/logout", "/accessDenied", "/css/", "/js/", "/images/", "/assets/"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req  = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String ctx = req.getContextPath();
        String path = req.getRequestURI().substring(ctx.length()); // bắt đầu bằng "/..."

        // cho phép public
        boolean isPublic = PUBLIC.stream().anyMatch(path::startsWith);
        if (isPublic) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        User auth = session == null ? null : (User) session.getAttribute("authUser");
        if (auth == null) {
            // chưa login -> redirect tới login
            resp.sendRedirect(ctx + "/login");
            return;
        }

        String role = auth.getRole() == null ? "" : auth.getRole();

        // CHẶN toàn bộ /users cho non-admin
        if (path.startsWith("/users")) {
            if (!"admin".equalsIgnoreCase(role)) {
                // redirect tới trang từ chối quyền
                resp.sendRedirect(ctx + "/accessDenied");
                return;
            }
        }

        // Nếu muốn, có thể thêm kiểm tra tinh vi hơn (ví dụ block delete trên /products với role != admin)
        // Example:
        // if (path.startsWith("/products") && "DELETE".equalsIgnoreCase(req.getMethod()) && !"admin".equalsIgnoreCase(role)) { deny... }

        chain.doFilter(request, response);
    }
}
