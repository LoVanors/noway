package com.example.noway.servlets;

import com.example.noway.models.dtos.ConnectedUserDTO;
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
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.IOException;

@WebServlet(name = "deleteAccount", urlPatterns = "/deleteAccount")
public class DeleteAccountServlet extends HttpServlet {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;

    @Inject
    CustomerService customerService;
    @Inject
    private CustomerRepository customerRepository;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/deleteAccount.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //méthode de suppression de compte

        HttpSession session = request.getSession();
        Object connectedUserObj = session.getAttribute("connectedUser");
        ConnectedUserDTO connectedUser = (ConnectedUserDTO) connectedUserObj;
        Customer customer = customerRepository.findByUsername(connectedUser.getUsername());

        String username = connectedUser.getUsername();

        String confirmation = request.getParameter("confirmation");
        if (confirmation.equals("supprimer " + username)) {
            try {
                customerService.delete(customer);
            } catch (Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/pages/deleteAccount.jsp").forward(request, response);
                return;
            }

        }

        request.getSession().invalidate();
        response.sendRedirect("index.jsp");

    }


}