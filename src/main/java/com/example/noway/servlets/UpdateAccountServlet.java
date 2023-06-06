package com.example.noway.servlets;

import com.example.noway.exceptions.InvalidPasswordException;
import com.example.noway.models.dtos.ConnectedUserDTO;
import com.example.noway.models.entities.Customer;
import com.example.noway.repositories.CustomerRepository;
import com.example.noway.repositories.Impl.CustomerRepositoryImpl;
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
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet(name = "updateAccount", urlPatterns = "/updateAccount")
public class UpdateAccountServlet extends HttpServlet {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;

    @Inject
    CustomerService customerService;
    @Inject
    CustomerRepository customerRepository;

    @Override
    public void init() throws ServletException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/updateAccount.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//méthode de modification de compte
        HttpSession session = request.getSession();
        Object connectedUserObj = session.getAttribute("connectedUser");

        ConnectedUserDTO connectedUser = (ConnectedUserDTO) connectedUserObj;
        Customer connectedCustomer = customerRepository.findByUsername(connectedUser.getUsername());

        String customerUsername = connectedCustomer.getUsername();
        String confirmation = request.getParameter("oldPassword");
        Customer newCustomer = new Customer(customerUsername, confirmation);
        Customer customer = customerService.login(newCustomer);
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String confirmedPassword=request.getParameter("confirmedPassword");
        Boolean isAdmin = request.getParameter("setAdmin").equals(customer.getId());
        if (username.trim().equals("")){
            username=customer.getUsername();
        }
        if (email.trim().equals("")){
            email=customer.getEmail();
        }
        if (password.trim().equals("") && confirmedPassword.trim().equals("")){
            password=customer.getPassword();
        }
        if (!password.equals(confirmedPassword)){
            throw new InvalidPasswordException();
        }
        if (isAdmin==null){
            isAdmin=customer.getIsAdmin();
        }

        Customer updatedCustomer= new Customer(customer.getId(),username,email,password,isAdmin);
        updatedCustomer.setPassword(BCrypt.hashpw(password,BCrypt.gensalt()));
        customerRepository.update(updatedCustomer);

        request.getSession().invalidate();
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }


}