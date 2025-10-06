<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <style>
    body{font-family:Arial,Helvetica,sans-serif;background:#f5f7fb;padding:40px}
    .card{max-width:420px;margin:0 auto;background:#fff;padding:20px;border-radius:10px;box-shadow:0 8px 24px rgba(8,20,40,.08)}
    h2{margin-top:0}
    .field{margin:10px 0}
    label{display:block;margin-bottom:6px;font-size:14px}
    input[type="text"], input[type="password"]{width:100%;padding:8px;border:1px solid #d0d7de;border-radius:6px}
    .row{display:flex;align-items:center;gap:8px}
    .actions{margin-top:14px}
    button{background:#6C5CE7;color:#fff;border:none;padding:10px 14px;border-radius:8px;cursor:pointer}
    .hint{font-size:13px;color:#666;margin-top:10px}
    .error{color:#b00020;background:#ffecec;padding:8px;border-radius:6px;margin-bottom:8px}
  </style>
</head>
<body>
  <div class="card">
    <h2>Đăng nhập</h2>

    <c:if test="${not empty error}">
      <div class="error"><c:out value="${error}" /></div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/login" autocomplete="on">
      <div class="field">
        <label for="username">Username</label>
        <input id="username" type="text" name="username"
            value="<c:out value='${old_username}'/>"
            required autocomplete="username" />
      </div>

      <div class="field">
        <label for="password">Password</label>
        <!-- nếu bạn đã set req.setAttribute("old_password", ...) thì sẽ tiền điền -->
        <input id="password" type="password" name="password"
               value="<c:out value='${old_password}'/>"
               required autocomplete="current-password" />
      </div>

      <div class="field row">
        <!-- value="1" là chuẩn cho checkbox; server kiểm tra nếu param != null -->
        <input id="remember" type="checkbox" name="remember" value="1"
               <c:if test="${param.remember != null}">checked</c:if> />
        <label for="remember">Remember me (lưu 30 giây theo yêu cầu)</label>
      </div>

      <div class="actions">
        <button type="submit">Login</button>
      </div>

      <div class="hint">
        Nếu đăng nhập thất bại, username sẽ được giữ lại để bạn không phải gõ lại.
      </div>
    </form>
  </div>
</body>
</html>
