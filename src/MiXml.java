import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class MiXml {
    //Document representa todo el documento HTML o XML. Conceptualmente,
    // es la raíz del árbol del documento y proporciona el acceso principal a los datos del documento.
    private static Document document;
    public static Document generaXml ( ){
        //Permite que las aplicaciones obtengan un analizador que produce árboles de objetos DOM a partir de documentos XML.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try{
            //Permite obtener una instancias de documentos DOM de un documento XML.
            DocumentBuilder builder = factory.newDocumentBuilder();
            //La interfaz DOMImplementation proporciona los métodos para realizar operaciones que son
            // independientes de cualquier instancia particular del DOM.
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            //Element representa un elemento en un documento HTML o XML.
            //Sección para crear elementos
            //Se crea elemento raiz
            Element productos = document.createElement("Productos");
            //Creamos un nuevo elemento.
            Element jamon= document.createElement("Jamon");
            //Creamos un nuevo elemento.
            Element tipoJamon = document.createElement("Tipo de jamon");
            //Text hereda de CharacterData permite representa el contenido textual
            // (denominado datos de caracteres en XML) de un elemento o atributo.
            //Ingresamos la información.
            Text valTipoJamon = document.createTextNode("Pavo");
            //Creamos otro elemento
            Element precioJamon =  document.createElement("Precio");
            Text valPrecioJamon = document.createTextNode("2000");
            //Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0");
            //Añadimos la factura al documento
            document.getDocumentElement().appendChild(productos);
            //Añadimos el elemento hijo a la raíz
            productos.appendChild(jamon);
            //Añadimos elemento
            jamon.appendChild(tipoJamon);
            //Añadimos valor
            tipoJamon.appendChild(valTipoJamon);
            jamon.appendChild(precioJamon);
            precioJamon.appendChild(valPrecioJamon);
        }catch(Exception e){
            System.err.println("Ha ocurrido un error: " + e);
        }
        return document;
    }
}
