package com.example.noway.servlets;

import com.example.noway.models.entities.Customer;
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
import java.util.List;

@WebServlet(name = "manage", urlPatterns = "/manage")
public class ManageServlet extends HttpServlet {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;

    @Inject
    CustomerService customerService;

    @Override
    public void init() throws ServletException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/manage.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/manage.jsp").forward(request, response);
    }
}