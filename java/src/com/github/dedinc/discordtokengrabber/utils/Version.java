package com.github.dedinc.discordtokengrabber.utils;

import java.io.File;
import java.nio.file.Paths;

import com.github.dedinc.discordtokengrabber.Main;

public class Version {

	public String getChromeVersion() {		
		String chrome = Paths.get(Main.cd, "Users", Main.username, "AppData", "Local", "Google", "Chrome").toString();				
		String[] paths = {Paths.get(Main.cd, "Program Files", "Google", "Chrome", "Application").toString(), Paths.get(Main.cd, "Program Files (x86)", "Google", "Chrome", "Application").toString(),  Paths.get(chrome, "Application").toString()};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				File[] files = new File(paths[i]).listFiles();
				for (int k = 0; k != files.length; k++) {
					File file = files[k];
					String name = files[k].getName();					
					if (name.contains(".") && file.isDirectory()) {
						return name.split("\\.")[0];
					}
				}
			}
		}
		return null;
	}
	
	public String getYandexVersion() {
		String yandex = Paths.get(Main.cd, "Users", Main.username, "AppData", "Local", "Yandex", "YandexBrowser").toString();
		String[] paths = {Paths.get(Main.cd, "Program Files (x86)", "Yandex", "YandexBrowser").toString(), Paths.get(Main.cd, "Program Files", "Yandex", "YandexBrowser").toString(), Paths.get(yandex, "Application").toString()};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				File[] files = new File(paths[i]).listFiles();
				for (int k = 0; k != files.length; k++) {
					File file = files[k];
					String name = files[k].getName();					
					if (name.contains(".") && file.isDirectory()) {
						return name;
					}
				}
			}
		}
		return null;
	}
	
	public String getOperaVersion(boolean gx) {
		String path = "";
		if (!gx) {
			path = Paths.get(Main.cd, "Users", Main.username, "AppData", "Local", "Programs", "Opera").toString();
		} else {
			path = Paths.get(Main.cd, "Users", Main.username, "AppData", "Local", "Programs", "Opera GX").toString();
		}		
		File[] files = new File(path).listFiles();
		for (int k = 0; k != files.length; k++) {
			File file = files[k];
			String name = files[k].getName();
			if (name.contains(".") && file.isDirectory()) {
				return name.split("\\.")[0];
			}
		}
		return null;
	}
	
	public String getEdgeVersion() {
		String[] paths = {Paths.get(Main.cd, "Program Files", "Microsoft", "Edge", "Application").toString(), Paths.get(Main.cd, "Program Files (x86)", "Microsoft", "Edge", "Application").toString()};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				File[] files = new File(paths[i]).listFiles();
				for (int k = 0; k != files.length; k++) {
					File file = files[k];
					String name = files[k].getName();					
					if (name.contains(".") && file.isDirectory()) {
						return name.split("\\.")[0];
					}
				}
			}
		}
		return null;
	}
	
}
