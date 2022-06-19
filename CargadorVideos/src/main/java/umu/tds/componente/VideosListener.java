package umu.tds.componente;

import java.util.EventListener;
import java.util.EventObject;

public interface VideosListener extends EventListener{
	public void hayNuevosVideos(EventObject e);
}
