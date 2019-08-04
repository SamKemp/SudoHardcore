package live.samkemp.plugin.hardcore.hardcore;

import org.bukkit.plugin.java.JavaPlugin;

public final class Hardcore extends JavaPlugin
{

    public static int NoDeaths = 0;


    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new MyListeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
