package com.toni.ejercicio3;

import org.w3c.dom.*;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) throws Exception {

    boolean bucle = true;
    Scanner entrada = new Scanner(System.in);
    int eleccionUsuario = 0;


        //Crear objetos para usar el analizador
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        //Buscar en un nodo ya existente
        Document arbol = builder.parse(new File("src/main/resources/ejercicio3.xml"));

        //Retorna todo el arbol, llamado arbol.

        //Eliminar nodos de texto vacíos (no es obligado)
        arbol.getDocumentElement().normalize();











        while (bucle){

        System.out.println("Menú: \n");


        System.out.println("Opción 1 - Vista de todo el documento XML");
        System.out.println("Opción 2.- Listado de los libros prestados");
        System.out.println("Opción 3.- Listado de los libros en venta");
        System.out.println("Opción 4.- Salir");

        if (entrada.hasNextInt()){
            eleccionUsuario = entrada.nextInt();
            bucle = false;

        } else {
            System.out.println("Error.");
        }

    }



        switch (eleccionUsuario) {

            case 1:
                vistaDocumento(arbol);
                break;
            case 2:
                listadoLibrosPrestados(arbol);
                break;
            case 3:
                listadoLibrosVenta(arbol);
                break;
            case 4:
               // break;


                break;
            default:
                throw new IllegalStateException("Unexpected value: " + eleccionUsuario);
        }


    }

    public static void vistaDocumento(Document arbol) throws Exception {

        XmlCtrlDom xcd1 = new XmlCtrlDom();

        xcd1.escribirDocumentAXmlPantalla(arbol);
    }


    public static void listadoLibrosPrestados(Document arbol) throws XPathExpressionException {

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        String listadoPrestados = (String) xpath.evaluate("/libros/prestamo/libro", arbol, XPathConstants.STRING);

        System.out.println(listadoPrestados);



    }

    public static void listadoLibrosVenta(Document arbol) throws XPathExpressionException {


        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        String listadoPrestados = (String) xpath.evaluate("/libros/venta/libro", arbol, XPathConstants.STRING);

        System.out.println(listadoPrestados);




    }


}
