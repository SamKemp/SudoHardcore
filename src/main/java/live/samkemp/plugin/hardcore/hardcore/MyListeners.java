package live.samkemp.plugin.hardcore.hardcore;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class MyListeners implements Listener
{

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        Hardcore.NoDeaths++;
        World NewWorld = Bukkit.getServer().createWorld(new WorldCreator("World" + Hardcore.NoDeaths));
        NewWorld.setDifficulty(Difficulty.HARD);

        if(!event.getEntity().getWorld().getName().equalsIgnoreCase("world"))
            Bukkit.getServer().unloadWorld(event.getEntity().getWorld(), true);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        Location RespawnLocation = Bukkit.getServer().getWorld("World" + Hardcore.NoDeaths).getSpawnLocation();
        event.setRespawnLocation(RespawnLocation);

        event.getPlayer().getInventory().clear();
    }
}
