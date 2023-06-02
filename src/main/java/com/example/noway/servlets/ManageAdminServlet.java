package com.example.noway.servlets;

import com.example.noway.services.CustomerService;
import com.example.noway.services.Impl.CustomerServiceImpl;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "manageAdmin",urlPatterns = "/manageAdmin")
public class ManageAdminServlet extends HttpServlet {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;

    @Inject
    CustomerService customerService;
    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImpl();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/manageAdmin.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//méthode d'ajout d'admin (un ou plusieurs)
    }

}