package rikkei.academy.controller;

import rikkei.academy.model.BaiDoc;
import rikkei.academy.service.baidoc.BaiDocService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/BaiDoc")
public class BaiDocServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private BaiDocService baiDocService;

    public void init() {
        baiDocService = new BaiDocService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            try {
                switch (action) {
                    case "newbaidoc":
                        showNewForm(request, response);
                        break;
                    case "insert":
                        insertBaiDoc(request, response);
                        break;
                    case "delete":
                        deleteBaiDoc(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "update":
                        updateBaiDoc(request, response);
                        break;
                    default:
                        listBaiDoc(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
    }

    private void listBaiDoc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<BaiDoc> listBaiDoc = baiDocService.selectAllBaiDoc();
        request.setAttribute("listBaiDoc", listBaiDoc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewbaidoc/baidoc-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewbaidoc/baidoc-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BaiDoc existingBaiDoc = baiDocService.selectBaiDoc(id);
        request.setAttribute("baiDoc", existingBaiDoc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewbaidoc/baidoc-form.jsp");
        dispatcher.forward(request, response);

    }

    private void insertBaiDoc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name_baidoc");
        System.out.println(name);
        BaiDoc newBaiDoc = new BaiDoc(name);
        baiDocService.insertBaiDoc(newBaiDoc);
        listBaiDoc(request, response);
    }

    private void updateBaiDoc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name_baidoc");
        BaiDoc list = new BaiDoc(id, name);
        baiDocService.updateBaiDoc(list);
        listBaiDoc(request, response);
    }

    private void deleteBaiDoc(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        baiDocService.deleteBaiDoc(id);
        response.sendRedirect("/BaiDoc");

    }
}
