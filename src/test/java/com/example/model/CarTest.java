package com.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testCarConstructorAndGetters() {
        // Создайте объект Car с помощью конструктора.
        Car car = new Car("200HP", "Sedan", "Red", "Toyota", "Camry", "25000", "2021");

        // Проверьте, что значения, установленные в конструкторе, совпадают с теми, которые вы получаете с помощью геттеров.
        assertEquals("200HP", car.getEnginePower());
        assertEquals("Sedan", car.getBodyType());
        assertEquals("Red", car.getColor());
        assertEquals("Toyota", car.getManufacture());
        assertEquals("Camry", car.getModel());
        assertEquals("25000", car.getPrice());
        assertEquals("2021", car.getYearOfIssue());
    }

    @Test
    public void testCarSetters() {
        Car car = new Car();

        car.setEnginePower("150HP");
        car.setBodyType("SUV");
        car.setColor("Blue");
        car.setManufacture("Honda");
        car.setModel("CR-V");
        car.setPrice("30000");
        car.setYearOfIssue("2022");

        assertEquals("150HP", car.getEnginePower());
        assertEquals("SUV", car.getBodyType());
        assertEquals("Blue", car.getColor());
        assertEquals("Honda", car.getManufacture());
        assertEquals("CR-V", car.getModel());
        assertEquals("30000", car.getPrice());
        assertEquals("2022", car.getYearOfIssue());
    }

    @Test
    public void testCarToString() {
        // Создайте объект Car с заданными значениями.
        Car car = new Car("180HP", "Hatchback", "Silver", "Ford", "Focus", "20000", "2020");

        // Проверьте, что метод toString возвращает ожидаемую строку.
        String expectedToString = "Car{enginePower=180HP, bodyType='Hatchback', color='Silver', manufacture='Ford', model='Focus', price=20000, yearOfIssue=2020}";
        assertEquals(expectedToString, car.toString());
    }

}