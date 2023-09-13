package com.example.servlets;

import com.example.converter.CarConverter;
import com.example.dto.CarDTO;
import com.example.model.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream inputStream = getClass().getResourceAsStream("/cars.xml");
        if(inputStream.markSupported()) {
            System.out.println(true);
        }
        List<CarDTO> carsDTO = CarConverter.getCars("/Users/ilyadasko/Documents/Lab_PKP/MavenLab_6/src/main/resources/cars.xml");
        List<Car> cars = new ArrayList<>();
        for (CarDTO car:carsDTO) {
            try {
                car.validate();
                cars.add(car.toCar());
                System.out.println(car);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        req.setAttribute("cars", cars);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);
    }



}
