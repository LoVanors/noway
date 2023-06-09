package com.example.noway.servlets;

import com.example.noway.models.dtos.ConnectedUserDTO;
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

@WebServlet(name = "logout",urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
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
        request.getSession(true).setAttribute("connectedUser", null);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}