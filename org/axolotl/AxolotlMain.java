
package org.axolotl;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Wtnaut
 */
public class AxolotlMain extends JavaPlugin{
    
    @Override
    /**
     * triggers on enable
     */
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new AxolotlListener(getServer()), this);
        
    }
    @Override
    /**
     * triggers on disable
     */
    public void onDisable(){
    }
}
