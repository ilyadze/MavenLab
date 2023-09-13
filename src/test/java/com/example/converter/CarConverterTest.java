package com.example.converter;

import com.example.dto.CarDTO;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class CarConverterTest {

    @Test
    public void testGetCars() {
        String testXmlFilePath = "/Users/ilyadasko/Documents/Lab_PKP/MavenLab_6/src/main/resources/cars.xml";

        List<CarDTO> cars = CarConverter.getCars(testXmlFilePath);

        assertFalse(cars.isEmpty());


        CarDTO firstCar = cars.get(0);
        assertNotNull(firstCar.getEnginePower());
        assertNotNull(firstCar.getBodyType());
        assertNotNull(firstCar.getColor());
        assertNotNull(firstCar.getManufacture());
        assertNotNull(firstCar.getModel());
        assertNotNull(firstCar.getPrice());
        assertNotNull(firstCar.getYearOfIssue());
    }

    @Test
    public void testGetCarsWithInvalidFile() {
        // Проверьте, что метод обрабатывает некорректный файл и выбрасывает исключение.
        String invalidXmlFilePath = "invalid-cars.xml";
        assertThrows(RuntimeException.class, () -> {
            CarConverter.getCars(invalidXmlFilePath);
        });
    }

    @Test
    public void testGetCarsWithEmptyFile() {
        // Создайте пустой XML-файл для теста (например, test-empty-cars.xml).
        String emptyXmlFilePath = "/Users/ilyadasko/Documents/Lab_PKP/MavenLab_6/src/main/resources/test-empty-cars.xml";

        List<CarDTO> cars = CarConverter.getCars(emptyXmlFilePath);

        // Проверьте, что список машин пустой, если файл пустой.
        assertTrue(cars.isEmpty());
    }

    @Test
    public void testGetCarsWithNonExistentFile() {
        // Укажите несуществующий XML-файл для теста.
        String nonExistentXmlFilePath = "non-existent-file.xml";
        assertThrows(RuntimeException.class, () -> {
            CarConverter.getCars(nonExistentXmlFilePath);
        });
        // В этом тесте мы ожидаем исключение, так как файл не существует.

    }



}