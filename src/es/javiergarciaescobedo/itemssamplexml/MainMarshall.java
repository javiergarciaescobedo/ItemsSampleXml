package es.javiergarciaescobedo.itemssamplexml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MainMarshall {

    public static void main(String[] args) {
        // Crear un objeto que permita almacenar la lista de objetos, asignando
        //  una lista de tipo ArrayList que estará vacía inicialmente
        Items items = new Items();
        
        // Crear algunos objetos de muestra
        Item item;
        item = new Item(1, "uno", 111, Calendar.getInstance().getTime());
        items.getItemsList().add(item);
        item = new Item(2, "dos", 222, Calendar.getInstance().getTime());
        items.getItemsList().add(item);
        
        try {
            // Se indica el nombre de la clase que contiene la lista de objetos
            JAXBContext jaxbContext = JAXBContext.newInstance(Items.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // Indicar que se desea generar el xml con saltos de línea y tabuladores
            //  para facilitar su lectura
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            // Generar XML mostrándolo por la salida estándar
            jaxbMarshaller.marshal(items, System.out);
            
            // Generar XML guardándolo en un archivo local
            BufferedWriter bw = new BufferedWriter(new FileWriter("items.xml"));
            jaxbMarshaller.marshal(items, bw);
        } catch (JAXBException ex) {
            Logger.getLogger(MainMarshall.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainMarshall.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
