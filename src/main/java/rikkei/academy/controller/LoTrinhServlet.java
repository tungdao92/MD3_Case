package rikkei.academy.controller;

import rikkei.academy.service.lotrinh.LoTrinhService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//name = "AdminServlet", value = "/AdminServlet"
@WebServlet(value = {"/", "/lotrinh"})
public class LoTrinhServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoTrinhService loTrinhService;

    public void init() {
        loTrinhService = new LoTrinhService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        String home = request.getParameter("home");
        if (home != null) {
            request.getRequestDispatcher("/WEB-INF/profile/profile.jsp").forward(request, response);
            return;
        }

        try {
            System.out.println("action ----> " + action);
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<rikkei.academy.model.LoTrinh> listAdminn = loTrinhService.selectAllAdmin();
        request.setAttribute("listAdmin", listAdminn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewlotrinh/lotrinh-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewlotrinh/lotrinh-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        rikkei.academy.model.LoTrinh existingLoTrinh = loTrinhService.selectAdmin(id);
        request.setAttribute("loTrinh", existingLoTrinh);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewlotrinh/lotrinh-form.jsp");
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        rikkei.academy.model.LoTrinh newLoTrinh = new rikkei.academy.model.LoTrinh(name);
        loTrinhService.insertAdmin(newLoTrinh);
        listUser(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        rikkei.academy.model.LoTrinh list = new rikkei.academy.model.LoTrinh(id, name);
        loTrinhService.updateAdmin(list);
        listUser(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        loTrinhService.deleteAdmin(id);

        request.setAttribute("listAdmin", loTrinhService.selectAllAdmin());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewlotrinh/lotrinh-list.jsp");
        dispatcher.forward(request, response);

    }
}