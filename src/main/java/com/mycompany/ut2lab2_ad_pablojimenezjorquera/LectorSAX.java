package com.mycompany.ut2lab2_ad_pablojimenezjorquera;



import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LectorSAX {

    public static void main(String[] args) {
        try {
            //creamos la factoria y el analizador SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            //handler para capturar eventos del documento
            DefaultHandler manejador = new DefaultHandler() {
                private boolean esNombre = false;
                private String claseNave = "";

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("nave")) {
                        //guardamos la clase cuando entramos en <nave>
                        claseNave = attributes.getValue("clase");
                    } else if (qName.equalsIgnoreCase("nombre")) {
                        //activamos la bandera al entrar en <nombre>
                        esNombre = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (esNombre) {
                        //leemos el texto de <nombre> y lo mostramos
                        String nombre = new String(ch, start, length);
                        System.out.println("clase: " + claseNave + ", nombre de la nave: " + nombre);
                        esNombre = false;
                    }
                }
            };

            //lanzamos la lectura del archivo
            saxParser.parse(new File("imperio.xml"), manejador);

        } catch (Exception e) {
            System.err.println("Error al procesar con SAX: " + e.getMessage());
        }
    }
}