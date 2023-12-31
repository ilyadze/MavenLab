package com.example.converter;

import com.example.dto.CarDTO;
import com.example.factory.CarFactory;
import com.example.model.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CarConverter {

    public static List<CarDTO> getCars(String nameFile) {
        List<CarDTO> cars = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setIgnoringComments(true);

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
//            InputStream inputStream = XMLReader.class.getResourceAsStream("/cars.xml");
            Document document = builder.parse(nameFile);
            NodeList list = document.getElementsByTagName("car");
            for (int i = 0; i < list.getLength(); i++) {
                Node nNode = list.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    CarDTO carDTO = CarFactory.createCar(eElement.getElementsByTagName("engine_power").item(0).getTextContent(),
                             eElement.getElementsByTagName("body_type").item(0).getTextContent(),
                            eElement.getElementsByTagName("color").item(0).getTextContent(),
                            eElement.getElementsByTagName("manufacture").item(0).getTextContent(),
                            eElement.getElementsByTagName("model").item(0).getTextContent(),
                            eElement.getElementsByTagName("price").item(0).getTextContent(),
                            eElement.getElementsByTagName("year_of_issue").item(0).getTextContent());

                    cars.add(carDTO);
                }
            }



        } catch (SAXException | IOException | ParserConfigurationException | NullPointerException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

}
