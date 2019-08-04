package live.samkemp.plugin.hardcore.hardcore;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class Hardcore extends JavaPlugin
{

    static Random r = new Random();
    public static int RunKey = r.nextInt(9999) + 10000;
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
