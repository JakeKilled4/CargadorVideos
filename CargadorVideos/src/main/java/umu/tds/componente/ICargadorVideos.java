package umu.tds.componente;

import java.io.File;

public interface ICargadorVideos {
	public void cargarVideos(File videos) throws FicheroIncorrectoException;
}
