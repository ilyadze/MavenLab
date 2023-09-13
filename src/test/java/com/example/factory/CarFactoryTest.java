package com.example.factory;

import com.example.dto.CarDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    public void testCreateCar() {
        // Подготовка данных для теста
        String enginePower = "200HP";
        String bodyType = "Sedan";
        String color = "Red";
        String manufacture = "Toyota";
        String model = "Camry";
        String price = "25000";
        String yearOfIssue = "2022";

        // Вызов метода createCar
        CarDTO carDTO = CarFactory.createCar(enginePower, bodyType, color, manufacture, model, price, yearOfIssue);

        // Проверка созданного объекта CarDTO
        assertNotNull(carDTO);
        assertEquals(enginePower, carDTO.getEnginePower());
        assertEquals(bodyType, carDTO.getBodyType());
        assertEquals(color, carDTO.getColor());
        assertEquals(manufacture, carDTO.getManufacture());
        assertEquals(model, carDTO.getModel());
        assertEquals(price, carDTO.getPrice());
        assertEquals(yearOfIssue, carDTO.getYearOfIssue());
    }
}