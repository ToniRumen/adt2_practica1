package com.toni.ejercicio2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class App2 {

    public static void main(String[] args){

        try {

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document arbol = builder.newDocument();

            //No es necesario especificar la ruta aún, eso en el transformer.

            Element alumnos = arbol.createElement("alumnos");

            Node alumno1 = arbol.createElement("alumno");
            Node alumno2 = arbol.createElement("alumno");


            Node nombre = arbol.createElement("nombre");
            Node apellidos =  arbol.createElement("apellidos");
            Node edad =  arbol.createElement("edad");



            Node nombre2 = arbol.createElement("nombre");
            Node apellidos2 =  arbol.createElement("apellidos");
            Node edad2 =  arbol.createElement("edad");

            nombre.setTextContent("Juan");
            apellidos.setTextContent("Martí Lopez");
            edad.setTextContent("18");

            alumno1.appendChild(nombre);
            alumno1.appendChild(apellidos);
            alumno1.appendChild(edad);


            nombre2.setTextContent("Amparo");
            apellidos2.setTextContent("Luna Dolores");
            edad2.setTextContent("25");


            alumno2.appendChild(nombre2);
            alumno2.appendChild(apellidos2);
            alumno2.appendChild(edad2);

            arbol.appendChild(alumnos);
            alumnos.appendChild(alumno1);
            alumnos.appendChild(alumno2);


            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer idTransform = transFactory.newTransformer();
            idTransform.setOutputProperty(OutputKeys.METHOD, "xml");
            idTransform.setOutputProperty(OutputKeys.INDENT,"yes");
            Source input = new DOMSource(arbol); //Se guarda el arbol nuevo entero
            Result output = new StreamResult(
                    new FileOutputStream("src/main/resources/ejercicio2.xml"));
            idTransform.transform(input, output);

            /*Mostrar XML por pantalla.
            Result pantalla = new StreamResult(System.out);
            idTransform.transform(input, pantalla);
            */











        } catch (ParserConfigurationException e){
            System.out.println(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }


}
