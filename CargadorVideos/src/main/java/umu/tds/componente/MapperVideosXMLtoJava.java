package umu.tds.componente;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class MapperVideosXMLtoJava {

	public static Videos cargarVideos(File fichero) throws FicheroIncorrectoException {

		JAXBContext jc;
		Videos canciones = null;
		try {
		jc = JAXBContext.newInstance("umu.tds.componente");
		Unmarshaller u = jc.createUnmarshaller();
		canciones = (Videos) u.unmarshal(fichero);
		} catch (JAXBException e) {
			throw new FicheroIncorrectoException();
		}
		
		return canciones;
	}
}
