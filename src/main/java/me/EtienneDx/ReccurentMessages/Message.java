package me.EtienneDx.ReccurentMessages;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import net.md_5.bungee.api.ChatColor;

public class Message implements ConfigurationSerializable
{
	public String message = ChatColor.AQUA + "Hello, World!";
	
	public int intervalInMinutes = 5;
	
	public Message() { }
	
	public Message(String msg, int interval)
	{
		this.message = msg;
		this.intervalInMinutes = interval;
	}
	
	public Message(Map<String, Object> map)
	{
		this.message = ((String)map.get("message")).replace("&", "§");
		this.intervalInMinutes = Integer.valueOf(String.valueOf(map.get("intervalInMinutes")));
	}

	@Override
	public Map<String, Object> serialize()
	{
		HashMap<String, Object> map = new HashMap<>();

		map.put("message", message.replace("§", "&"));
		map.put("intervalInMinutes", intervalInMinutes);
		
		return map;
	}

}
