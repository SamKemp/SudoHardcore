package live.samkemp.plugin.hardcore.hardcore;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class MyListeners implements Listener
{

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        Bukkit.shutdown();
    }

}
