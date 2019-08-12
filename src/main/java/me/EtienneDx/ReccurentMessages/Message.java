package me.EtienneDx.ReccurentMessages;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class Message implements ConfigurationSerializable
{
	public String message = "Hello, World!";
	
	public int intervalInMinutes = 5;
	
	public Message() { }
	
	public Message(String msg, int interval)
	{
		this.message = msg;
		this.intervalInMinutes = interval;
	}
	
	public Message(Map<String, Object> map)
	{
		this.message = (String)map.get("message");
		this.intervalInMinutes = Integer.valueOf(String.valueOf(map.get("intervalInMinutes")));
	}

	@Override
	public Map<String, Object> serialize()
	{
		HashMap<String, Object> map = new HashMap<>();

		map.put("message", message);
		map.put("intervalInMinutes", intervalInMinutes);
		
		return map;
	}

}
