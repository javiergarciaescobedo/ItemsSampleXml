package es.javiergarciaescobedo.itemssamplexml;

import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class MainUnmarshallUrl {

    public static void main(String[] args) {
        try {
            // Crear objeto JAXB para interpretar objetos 'Items' desde XML
            JAXBContext jaxbContext = JAXBContext.newInstance(Items.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Generar lista de objetos desde XML descargado de URL
            URL url = new URL("http://213.96.173.88:8088/ItemsSampleDBJavaWeb/Main");
            InputStream is = url.openStream();
            Items items = (Items) jaxbUnmarshaller.unmarshal(is);
            
            // Mostrar el contenido de la lista obtenida
            for (Item item : items.getItemsList()) {
                System.out.println("id: " + item.getId());
                System.out.println("astring: " + item.getAstring());
                System.out.println("anumber: " + item.getAnumber());
                System.out.println("adate: " + item.getAdate());
                System.out.println();
            }
        } catch (Exception ex) {
            Logger.getLogger(MainUnmarshallUrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
