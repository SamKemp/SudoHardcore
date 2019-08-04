package live.samkemp.plugin.hardcore.hardcore;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class Hardcore extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new MyListeners(), this);
    }
}
