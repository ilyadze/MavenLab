<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <%
            List<Car> names = (List<Car>) request.getAttribute("cars");

            if (names != null && !names.isEmpty()) {
                for (Car s : names) {
                    out.println("<li>" + "Car - " + "Manufacture: " + s.getManufacture()
                            + ", model: " + s.getModel()
                            + ", color: " + s.getColor()
                            + ", body type: " + s.getBodyType()
                            + ", price: " + s.getPrice()
                            + ", engine power: " + s.getEnginePower()
                            + ", year of issue: " + s.getYearOfIssue() + "</li>");
                }
            }
        %>
    </ul>
</body>
</html>
