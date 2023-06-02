package com.example.noway.servlets;

import com.example.noway.models.entities.Customer;
import com.example.noway.models.forms.CustomerRegisterForm;
import com.example.noway.services.CustomerService;
import com.example.noway.services.Impl.CustomerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private CustomerService customerService;
    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImpl();
    }
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

        CustomerRegisterForm registerForm = new CustomerRegisterForm(username, email, password);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CustomerRegisterForm>> violations = validator.validate(registerForm);

        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder();
            for (ConstraintViolation<CustomerRegisterForm> violation : violations) {
                if (violation.getPropertyPath().toString().equals("email")){
                    request.setAttribute("errorMessage","Email invalide");
                }
                if (violation.getPropertyPath().toString().equals("username")){
                    request.setAttribute("errorMessage","Nom d'utilisateur invalide");
                }
                if (violation.getPropertyPath().toString().equals("password")){
                    request.setAttribute("errorMessage","Mot de passe invalide");
                }
            }
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }

        Customer newCustomer = new Customer(username, email, password);

        try {
            customerService.register(newCustomer);
        } catch (Exception e) {
            request.setAttribute("errorMessage",  e.getMessage());
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}