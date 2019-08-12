package me.EtienneDx.ReccurentMessages;

import java.util.Arrays;
import java.util.List;

import me.EtienneDx.AnnotationConfig.AnnotationConfig;
import me.EtienneDx.AnnotationConfig.ConfigField;
import me.EtienneDx.AnnotationConfig.ConfigFile;

@ConfigFile(header = "Configuration for the Reccurent Messages plugin")
public class Config extends AnnotationConfig
{
    public final String configFilePath = ReccurentMessages.pluginDirPath + "config.yml";
    public final String logFilePath = ReccurentMessages.pluginDirPath + "Reccurent_Messages.log";
    
    @ConfigField(name = "Messages", comment = "List of all messages and timings")
    public List<Message> messages = Arrays.asList(new Message(), new Message("Another message", 10));
    
    @Override
    public void loadConfig()
    {
        this.loadConfig(this.configFilePath);
    }
    
    @Override
    public boolean saveConfig()
    {
        return this.saveConfig(this.configFilePath);
    }
}
