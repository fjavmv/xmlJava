import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class GuardarXml {

    private static final Integer INDENTACION = 3;
    // Guardamos la estrutura xml en un archivo
    public static void guardaXml(Document document, String directorio){
        try {
             //Se puede usar una instancia de TransformerFactory para crear objetos Transformer y Templates.
            // La propiedad del sistema que determina qué implementación de Factory crear se denomina "javax.xml.transform.TransformerFactory".
            // Esta propiedad nombra una subclase concreta de la clase abstracta TransformerFactory.
            // Si la propiedad no está definida, se utilizará un valor predeterminado de la plataforma.
            TransformerFactory transformerFactory= TransformerFactory.newInstance();
            //Damos formato al documento. Añadimos indentación  y la cabecera de XML
            transformerFactory.setAttribute("indent-number", INDENTACION);
            //Permite transformar la fuente de origen (árbol de origen) en un árbol de resultados.
            //Se puede obtener una instancia de esta clase con el método TransformerFactory.newTransformer.
            // Luego, esta instancia se puede usar para procesar XML de una variedad de fuentes
            // y escribir la salida de la transformación en una variedad de receptores.
            Transformer transformer = transformerFactory.newTransformer();
            //Establezca una propiedad de salida que estará en vigor para la transformación.
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

            //Hacemos la transformación
            StringWriter stringWriter = new StringWriter();
            //Actúa como almacen de un resultado de transformación, que puede ser XML,
            // texto sin formato, HTML,etc.
            StreamResult streamResult = new StreamResult(stringWriter);
            //Actúa como soporte para un árbol de origen de transformación en forma de árbol de modelo de objeto de documento (DOM).
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, streamResult);

            //Mostrar información a guardar por consola (opcional)
            try {
                //Creamos fichero para escribir en modo texto
                PrintWriter writer = new PrintWriter(new FileWriter(directorio));

                //Escribimos todo el árbol en el fichero
                writer.println(stringWriter);

                //Cerramos el archivo
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
