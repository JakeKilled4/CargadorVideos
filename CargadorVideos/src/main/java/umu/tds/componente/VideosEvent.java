package umu.tds.componente;

import java.util.EventObject;

@SuppressWarnings("serial")
public class VideosEvent extends EventObject{
	protected Videos videos;
	public VideosEvent(Object fuente, Videos videos) {
		super(fuente);
		this.videos = videos;
	}
	public Videos getVideos() {
		return this.videos;
	}
}
