package umu.tds.componente;

import java.io.File;
import java.io.Serializable;
import java.util.Vector;

@SuppressWarnings("serial")
public class CargadorVideos implements ICargadorVideos, Serializable{
	private Vector<VideosListener> videosListener = new Vector<VideosListener>();
	private File archivoVideos;
	
	public synchronized void addVideosListener(VideosListener listener) {
		videosListener.addElement(listener);
	}
	public synchronized void removeVideosListener(VideosListener listener) {
		videosListener.removeElement(listener);
	}
	
	public void cargarVideos(File videos) throws FicheroIncorrectoException {
		this.archivoVideos = videos;
		Videos v =  MapperVideosXMLtoJava.cargarVideos(this.archivoVideos);
		VideosEvent event = new VideosEvent(this, v);
		notificarCambio(event);
	}
	
	@SuppressWarnings("unchecked")
	private void notificarCambio(VideosEvent event) {
		Vector<VideosListener> lista;
		synchronized(this){
			lista = (Vector<VideosListener>)videosListener.clone();
		}
		for(VideosListener vl : lista)
			vl.hayNuevosVideos(event);
	}
}