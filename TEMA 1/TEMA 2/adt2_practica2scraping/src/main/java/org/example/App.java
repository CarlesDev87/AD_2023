package org.example;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class App {
    public static final String url = "https://www.amazon.es/gp/bestsellers/sports/ref=zg_bs_nav_sports_0";
    public static void main(String[] args) {

        if (getStatusConnectionCode(url) == 200) {

            // Obtengo el HTML de la web en un objeto Document
            Document document = getHtmlDocument(url);

            // Busco todas las entradas que estan dentro de:
            Elements entradas = document.select("div#gridItemRoot");
            System.out.println("Número de entradas en la página inicial de Amazon: "+entradas.size()+"\n");

            // Paseo cada una de las entradas
            for (Element elem : entradas) {
                String titulo = elem.getElementsByClass("_cDezb_p13n-sc-css-line-clamp-3_g3dy1").text();
                String precio = elem.getElementsByClass("_cDEzb_p13n-sc-price_3mJ9Z").text();

                System.out.println ("Producto: " +titulo+ ", Precio :"+ precio +"\n");

                // Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
                // Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
            }

        }else
            System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(url));
    }




    public static int getStatusConnectionCode(String url) {

        Response response = null;

        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }

    public static Document getHtmlDocument(String url) {

        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }
        return doc;
    }


}