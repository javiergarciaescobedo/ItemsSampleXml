package es.javiergarciaescobedo.itemssamplexml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class MainUnmarshallUrl {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("items.xml"));
            JAXBContext jaxbContext = JAXBContext.newInstance(Items.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Items items = (Items) jaxbUnmarshaller.unmarshal(br);
            for (Item item : items.getItemsList()) {
                System.out.println("id: " + item.getId());
                System.out.println("astring: " + item.getAstring());
                System.out.println("anumber: " + item.getAnumber());
                System.out.println("adate: " + item.getAdate());
                System.out.println();
            }
        } catch (JAXBException ex) {
            Logger.getLogger(MainUnmarshallUrl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainUnmarshallUrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
