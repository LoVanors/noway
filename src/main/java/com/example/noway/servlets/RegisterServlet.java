package com.example.noway.servlets;

import com.example.noway.models.entities.Customer;
import com.example.noway.services.CustomerService;
import com.example.noway.services.Impl.CustomerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmedPassword = request.getParameter("confirmedPassword");


        if (!password.equals(confirmedPassword)) {
            request.setAttribute("errorMessage", "Password not the same");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }

        Customer newCustomer = new Customer(username, email, password);

        try {

            customerService.register(newCustomer);

            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (Exception e) {

            request.setAttribute("errorMessage", "Failed to add customer: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }
    }
}