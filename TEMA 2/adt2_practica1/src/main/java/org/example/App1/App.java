package org.example.App1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {


        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document document = builder.parse(new File("src/main/resources/libros.xml"));
            document.getDocumentElement().normalize();

            Element rootElement = document.getDocumentElement();


            NodeList hijos = rootElement.getChildNodes();

            for (int i = 0; i < hijos.getLength(); i++) {
                Node nodo = hijos.item(i);
                if (nodo instanceof Element) {
                    System.out.println(nodo.getNodeName());
                }
            }

            ////////////////////////////////
            //  AÑADIR LIBRO CON DOM     //
            ///////////////////////////////


            Element libro = document.createElement("libro"); //creamos el libro nuevo y le añadimos los atributos

            libro.setAttribute("isbn", "35259326");

            Element titulo = document.createElement("titulo");
            libro.appendChild(titulo);   //configuramos el titulo como hijo de libro
            titulo.setTextContent("La guerra de los mundos");  //le ponemos un titulo al nuevo nodo de libro

            Element autor = document.createElement("Autor"); //añadimos un autor al libro
            libro.appendChild(autor);
            autor.setTextContent("Martin Scorsese");

            Element anyo = document.createElement("Año");   //añadimos un año al libro
            libro.appendChild(anyo);
            anyo.setTextContent("2005");

            Element editorial = document.createElement("Editorial");    //añadimos la editorial al libro
            libro.appendChild(editorial);
            editorial.setTextContent("Alfaguara");

            NodeList listaNodos = document.getElementsByTagName("prestamo");    //obtenemos una lista de los nodos de tipo prestamo
            Element nodoPrestamo = (Element) listaNodos.item(0); // inertamos en el primer nodo, puesto que solo hay uno
            nodoPrestamo.appendChild(libro);    //configuramos como hijo de prestamo el nuevo nodo de libro

            File xmlNuevo = new File("src/main/resources/libros2.xml");


                //CON EL TRANSFORMER INTRODUCIMOS EL NUEVO LIBRO EN EL XML

                Transformer trans = TransformerFactory.newInstance().newTransformer();
                trans.setOutputProperty(OutputKeys.METHOD, "xml");
                trans.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult("src/main/resources/libros.xml");
                trans.transform(source, result);



            ////////////////////////////////
            //  AÑADIR LIBRO CON XPATH   //
            ///////////////////////////////


            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            Node nodo = (Node) xPath.evaluate("/libros/prestamo", rootElement, XPathConstants.NODE);
            nodo.appendChild(libro);


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }
}