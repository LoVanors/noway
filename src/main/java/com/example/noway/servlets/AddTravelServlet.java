package com.example.noway.servlets;

import com.example.noway.models.entities.Travel;
import com.example.noway.services.CustomerService;
import com.example.noway.services.Impl.CustomerServiceImpl;
import com.example.noway.services.Impl.TravelServiceImpl;
import com.example.noway.services.TravelService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "addTravel", urlPatterns = "/addTravel") @MultipartConfig
public class AddTravelServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/noway";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgre";
    @Inject
    private TravelService travelService;


    @Override
    public void init() throws ServletException {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addTravel.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String destination = request.getParameter("destination");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String startDate = request.getParameter("startDate");
        LocalDate parsedStartDate = LocalDate.parse(startDate);
        String endDate = request.getParameter("endDate");
        LocalDate parsedEndDate = LocalDate.parse(endDate);

        Part imagePart = request.getPart("image");
        String imageName = imagePart.getSubmittedFileName();
        InputStream imageStream = imagePart.getInputStream();

        Path imageDirectory = Paths.get("C:\\Users\\studentdev09\\Desktop\\java\\noway\\src\\main\\webapp\\images\\"+ imageName);
        Files.createDirectories(imageDirectory.getParent());

        Travel travel=new Travel(destination ,description ,parsedStartDate ,parsedEndDate , BigDecimal.valueOf(Long.parseLong(price)),imageName);

        try {
            travelService.add(travel);
            Files.copy(imageStream, imageDirectory, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            request.setAttribute("errorMessage",  e.getMessage());
            request.getRequestDispatcher("/WEB-INF/pages/addTravel.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("/WEB-INF/pages/manageTravel.jsp").forward(request,response);
    }
}

