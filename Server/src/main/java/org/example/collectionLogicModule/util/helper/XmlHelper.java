package org.example.collectionLogicModule.util.helper;

import org.example.collectionLogicModule.util.dto.MusicBandServiceDTO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlHelper {
    public static void parseMusicBandsToXml(MusicBandServiceDTO serviceDTO, String filename) {
        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        Path fileOut = Paths.get(filename);
        try (
                OutputStream outputStream =
                        new BufferedOutputStream(Files.newOutputStream(fileOut));
        ) {
            XMLEventWriter xew = xof.createXMLEventWriter(outputStream);
            JAXBContext jc = JAXBContext.newInstance(MusicBandServiceDTO.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(serviceDTO, xew);
        } catch (IOException | XMLStreamException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static MusicBandServiceDTO parseXmlToMusicBands(String filename) throws IOException {
        InputStream inputStream = Files.newInputStream(Path.of(filename));
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {
            JAXBContext jc = null;
            try {
                jc = JAXBContext.newInstance(MusicBandServiceDTO.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                return (MusicBandServiceDTO) unmarshaller.unmarshal(inputStreamReader);
            } catch (JAXBException e) {
                System.out.println("Problems with parsing the xml file");
                throw new RuntimeException(e);
            }
        }
    }
}
