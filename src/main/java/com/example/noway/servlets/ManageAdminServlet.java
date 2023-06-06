package com.example.noway.servlets;

import com.example.noway.models.entities.Customer;
import com.example.noway.repositories.CustomerRepository;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "manageAdmin", urlPatterns = "/manageAdmin")
public class ManageAdminServlet extends HttpServlet {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;

    @Inject
    CustomerService customerService;
    @Inject
    CustomerRepository customerRepository;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerRepository.getAll();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/WEB-INF/pages/manageAdmin.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//méthode d'ajout d'admin (un ou plusieurs)
        List<Customer> customerList = customerRepository.getAll();
        String[] setAdminValues= request.getParameterValues("isAdminCB");
        System.out.println(setAdminValues);
        if (setAdminValues!=null) {
            for (Customer customer : customerList) {
                String customerId = String.valueOf(customer.getId());
                System.out.println(customerId);
                boolean isAdmin=Arrays.asList(setAdminValues).contains(customerId);
                System.out.println(isAdmin);
                if (customer.getIsAdmin()!=isAdmin){
                    customer.setIsAdmin(isAdmin);
                    customerRepository.update(customer);
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/pages/manage.jsp").forward(request, response);
    }

}