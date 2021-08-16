package com.github.dedinc.discordtokengrabber.utils;

import java.io.File;
import java.nio.file.Paths;

import com.github.dedinc.discordtokengrabber.Main;

public class Binaries {

	public boolean getChromeBinary() {
		String[] paths = {Paths.get(Main.cd, "Program Files", "Google", "Chrome", "Application", "chrome.exe").toString(), Paths.get(Main.cd, "Program Files (x86)", "Google", "Chrome", "Application", "chrome.exe").toString(),  Paths.get(Main.cd, "Users", Main.username, "AppData", "Local", "Google", "Chrome", "Application", "chrome.exe").toString()};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean getYandexBinary() {		
		String[] paths = {Paths.get(Main.cd, "Program Files (x86)", "Yandex", "YandexBrowser", "browser.exe").toString(), Paths.get(Main.cd, "Program Files", "Yandex", "YandexBrowser", "browser.exe").toString(), Paths.get(Main.cd, "Users", Main.username, "AppData", "Local", "Yandex", "YandexBrowser", "Application", "browser.exe").toString()};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				return true;
			}			
		}
		return false;
	}
	
	public boolean getOperaBinary(boolean gx) {
		String path = "";
		if (!gx) {
			path = Paths.get(Main.cd, "Users", Main.username, "AppData", "Local", "Programs", "Opera", "launcher.exe").toString();
		} else {
			path = Paths.get(Main.cd, "Users", Main.username, "AppData", "Local", "Programs", "Opera GX", "launcher.exe").toString();
		}
		if (new File(path).exists()) {
			return true;
		}
		return false;
	}
	
	public boolean getFirefoxBinary() {
		String[] paths = {Paths.get(Main.cd, "Program Files", "Mozilla Firefox", "firefox.exe").toString(), Paths.get(Main.cd, "Program Files (x86)", "Mozilla Firefox", "firefox.exe").toString()};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean getEdgeBinary() {
		String[] paths = {Paths.get(Main.cd, "Program Files", "Microsoft", "Edge", "Application", "msedge.exe").toString(), Paths.get(Main.cd, "Program Files (x86)", "Microsoft", "Edge", "Application", "msedge.exe").toString()};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				return true;
			}
		}
		return false;
	}
	
}
