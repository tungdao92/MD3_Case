package rikkei.academy.controller;

import rikkei.academy.model.LoTrinh;
import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
import rikkei.academy.model.User;
import rikkei.academy.service.lotrinh.ILoTrinhService;
import rikkei.academy.service.lotrinh.LoTrinhServiceIMPL;
import rikkei.academy.service.role.IRoleService;
import rikkei.academy.service.role.RoleServiceIMPL;
import rikkei.academy.service.user.IUserService;
import rikkei.academy.service.user.UserServiceIMPL;

import java.awt.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/users")
public class UserController extends HttpServlet {
    private ILoTrinhService loTrinhService = new LoTrinhServiceIMPL();

    private IRoleService roleService = new RoleServiceIMPL();
    private IUserService userService = new UserServiceIMPL();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                showFormRegister(request, response);
                break;
            case "login":
                showFormLogin(request, response);
                break;
            case "logout":
                logOut(request, response);
                break;
            case "change_avatar":
                showUploadAvatar(request, response);
                break;
            case "user":
                try {
                    showFormuser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit_user":
                formEditUser(request, response);
                break;
            case "delete_user":
                formDeleteUser(request,response);
                break;
        }
    }

    private void formDeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        List<Role> roleList = new ArrayList<>(user.getRoles());
        user.setRoleList(roleList);
        request.setAttribute("delete_user",user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/edit_user/delete_user.jsp");
        requestDispatcher.forward(request,response);
    }


    private void formEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        List<Role> roleList = new ArrayList<>(user.getRoles());//fix bug
        user.setRoleList(roleList);
        request.setAttribute("edit_user", user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/edit_user/edit_user.jsp");
        requestDispatcher.forward(request, response);

    }

    private void showFormuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> userList = userService.getList();

        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/quan-ly-user/user-manager.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                actionRegister(request, response);
                break;
            case "login":
                actionLogin(request, response);
                break;
            case "change_avatar":
                actionUploadAvatar(request, response);
                break;
            case "edit_user":
                try {
                    actionEditUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete_user":
                try {
                    actionDeleteUser(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }

    private void actionDeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteuser(id);
        request.setAttribute("message","delete success!");
        showFormuser(request,response);
//        RequestDispatcher requestDispatcher= request.getRequestDispatcher("/WEB-INF/view/quan-ly-user/user-manager.jsp");
//        requestDispatcher.forward(request,response);
    }

    private void actionEditUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String role = request.getParameter("role");
        if (role.equalsIgnoreCase("admin")){
            role = String.valueOf(3);
        }else {
            role = String.valueOf(1);
        }
         userService.updateUser( id, Integer.parseInt(role));
        request.setAttribute("message","edit success!");
        showFormuser(request,response);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/edit_user/edit_user.jsp");
//        requestDispatcher.forward(request,response);



    }

    public void destroy() {
    }

    public void showFormRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/register.jsp");
        dispatcher.forward(request, response);
    }

    public void actionRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = "userasfdasfasd";
        Set<String> strRole = new HashSet<>();
        Set<Role> roles = new HashSet<>();
        strRole.add(role);
        strRole.forEach(role1 -> {
            switch (role1) {
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN);
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM);
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER);
                    roles.add(userRole);
            }
        });
        System.out.println("roles set ---> " + roles);
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        if (userService.existedByUsername(username)) {
            request.setAttribute("message", "The username existed! Please try again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/register.jsp");
            dispatcher.forward(request, response);
//            return;
        }
        String email = request.getParameter("email");
        if (userService.existedByEmail(email)) {
            request.setAttribute("message", "The email existed! Please try again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/register.jsp");
            dispatcher.forward(request, response);
//            return;
        }
        String password = request.getParameter("password");
        String confirm_pass = request.getParameter("repeat_pass");
        if (!password.equals(confirm_pass)) {
            request.setAttribute("message", "The password do not match!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/register.jsp");
            dispatcher.forward(request, response);
            return;
        }
        User user = new User(name, username, email, password, roles);
        userService.save(user);
        request.setAttribute("success", "Create user success!!");
        response.sendRedirect("/users?action=login");
    }

    //LOGIN
    public void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/login.jsp");
        dispatcher.forward(request, response);
    }

    public void actionLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findByUsernameAndPassword(username, password);
        String pageJSP = "";
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            User allInfo = userService.findById(user.getId());

            List<Role> roleList = new ArrayList<>(allInfo.getRoles());
            if (roleList.get(0).getName() == RoleName.ADMIN) {
                pageJSP = "WEB-INF/profile/profile.jsp";

            } else {
                pageJSP = "WEB-INF/profile/profile-user.jsp";
            }

        } else {
            pageJSP = "WEB-INF/form-login/login.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(pageJSP);
        dispatcher.forward(request, response);
    }

    //LOG OUT
    public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
    }

    public void showUploadAvatar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/upload/upload_avatar.jsp");
        requestDispatcher.forward(request, response);
    }

    public void actionUploadAvatar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String avatar = request.getParameter("avatar");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getId();
        userService.changeAvatar(avatar, id);
        request.setAttribute("avatar", avatar);
        session.setAttribute("avatar", avatar);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/profile/account-profile.jsp");
        dispatcher.forward(request, response);

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/navbar/lotrinh/js.jsp");


    }
}