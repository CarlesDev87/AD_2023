package org.example.App2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class App2 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
