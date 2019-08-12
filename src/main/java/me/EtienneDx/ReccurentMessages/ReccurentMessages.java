package me.EtienneDx.ReccurentMessages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ReccurentMessages extends JavaPlugin
{
	public Logger log;
    public Config config;
	public final static String pluginDirPath = "plugins" + File.separator + "ReccurentMessages" + File.separator;
	
	public void onEnable()
	{
        this.log = getLogger();
        
        this.config = new Config();
        this.config.loadConfig();// loads config or default
        if(!this.config.saveConfig())// save eventual default
        {
        	addLogEntry("Error while saving config");
        }
        else
        {
        	log.info("Successfully loaded config");
        }
        addLogEntry("Enabling...");
        
        
        /*manager = new BukkitCommandManager(this);
        manager.enableUnstableAPI("help");
        registerConditions();
        manager.registerCommand(new RECommand());*/
        
        for(Message msg : config.messages)
        {
        	new BukkitRunnable()
        	{
    			@Override
    			public void run()
    			{
    				Bukkit.broadcastMessage(msg.message);
    			}
    		}.runTaskTimer(this, 0, msg.intervalInMinutes * 1200L);// run every 60 seconds
        }
	}

    public void addLogEntry(String entry)
    {
        try
        {
            File logFile = new File(this.config.logFilePath);
            
            File f = logFile.getParentFile();
            
            if(f != null)
            	f.mkdirs();
            
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            FileWriter fw = new FileWriter(logFile, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(entry);
            pw.flush();
            pw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
