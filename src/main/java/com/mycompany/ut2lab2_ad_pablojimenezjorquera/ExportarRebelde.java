package com.mycompany.ut2lab2_ad_pablojimenezjorquera;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.File;

public class ExportarRebelde {

    public static void main(String[] args) {
        //creamos el objeto con los datos del personaje
        Personaje luke = new Personaje("Luke Skywalker", "Comandante / Caballero Jedi");
        File archivoSalida = new File("rebelde.xml");

        try {
            //creamos el contexto JAXB indicando la clase
            JAXBContext contexto = JAXBContext.newInstance(Personaje.class);
            Marshaller marshaller = contexto.createMarshaller();
            //guardamos el objeto en el archivo XML
            marshaller.marshal(luke, archivoSalida);
            System.out.println("Personaje exportado correctamente a 'rebelde.xml'.");

        } catch (Exception e) {
            System.err.println("Error al realizar el Marshalling: " + e.getMessage());
        }
    }
}