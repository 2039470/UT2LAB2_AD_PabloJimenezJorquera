/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut2lab2_ad_pablojimenezjorquera;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author DAM2P
 */
public class LectorDOM {
    public static void main(String[] args) {
        try {
            //ponemos la factoria y el constructor DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            //parseamos el archivo cargándolo en memoria por completo
            Document doc = builder.parse(new File("imperio.xml"));
            doc.getDocumentElement().normalize();

            //mostramos el nombre del elemento raíz
            System.out.println("elemento raiz: " + doc.getDocumentElement().getNodeName());

            //obtenemos la lista de todas las etiquetas <nave>
            NodeList listaNaves = doc.getElementsByTagName("nave");

            //recorremos el árbol de nodos
            for (int i = 0; i < listaNaves.getLength(); i++) {
                Node nodo = listaNaves.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    // Extraemos atributos y nodos hijos
                    String id = elemento.getAttribute("id");
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    String piloto = elemento.getElementsByTagName("piloto").item(0).getTextContent();

                    System.out.println("nave_id: " + id + ", nombre: " + nombre + ", piloto: " + piloto);
                }
            }

        } catch (Exception e) {
            System.err.println("Error al procesar con DOM: " + e.getMessage());
        }
    }
}

