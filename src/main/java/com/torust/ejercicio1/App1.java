package com.torust.ejercicio1;

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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class App1 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        //Crear objetos para usar el analizador
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        /*
        Para crear un nodo document vacío:
        Document document = builder.newDocument();
        */

        //Buscar en un nodo ya existente
        Document arbol = builder.parse(new File("src/main/resources/ejercicio1.xml"));

        //Retorna todo el arbol, llamado arbol.

        //Eliminar nodos de texto vacíos (no es obligado)
        arbol.getDocumentElement().normalize();

        //Elemento raíz
        Element rootElement = arbol.getDocumentElement();

        NodeList listadoPrestamos = rootElement.getElementsByTagName("prestamo");

        /*
        No hace falta crear un árbol nuevo, solo hace falta crear un elemento
        y añadirlo al árbol.
        */



        //Crear elemento de tipo préstamo
        Element libroPrestamoNuevo = arbol.createElement("prestamo");

        Element libroNuevo = arbol.createElement("libro");

        //Atributo isbn
        libroNuevo.setAttribute("isbn","3243242");

       Node titulo = arbol.createElement("titulo");
       Node autor = arbol.createElement("autor");
       Node anyo = arbol.createElement("anyo");
       Node editorial = arbol.createElement("editorial");

        libroNuevo.appendChild(titulo);
        libroNuevo.appendChild(autor);
        libroNuevo.appendChild(anyo);
        libroNuevo.appendChild(editorial);

        libroPrestamoNuevo.appendChild(libroNuevo);

        //Lo añadimos, aunque sea delante, da igual (en teoría lo mete al final)
        listadoPrestamos.item(0).appendChild(libroPrestamoNuevo);


        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer idTransform = transFactory.newTransformer();
        idTransform.setOutputProperty(OutputKeys.METHOD, "xml");
        idTransform.setOutputProperty(OutputKeys.INDENT,"yes");
        Source input = new DOMSource(libroPrestamoNuevo); //Funcionará?
        Result output = new StreamResult(
                new FileOutputStream("serializacionXML-JAXP.xml"));
        idTransform.transform(input, output);
//Mostrar XML por pantalla.
        Result pantalla = new StreamResult(System.out);
        idTransform.transform(input, pantalla);




    }
}