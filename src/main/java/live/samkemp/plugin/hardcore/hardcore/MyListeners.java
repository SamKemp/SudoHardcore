package live.samkemp.plugin.hardcore.hardcore;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class MyListeners implements Listener
{

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        Hardcore.NoDeaths++;

        Location RespawnLocation = Bukkit.getServer().getWorld("world").getSpawnLocation();

        event.getPlayer().getInventory().clear();

        event.setRespawnLocation(RespawnLocation);

        World NewWorld = new WorldCreator("World" + Hardcore.NoDeaths).generateStructures(true).type(WorldType.NORMAL).createWorld();
        NewWorld.setDifficulty(Difficulty.HARD);
        NewWorld.setKeepSpawnInMemory(false);

        if(!event.getPlayer().getWorld().getName().equalsIgnoreCase("world"))
            Bukkit.getServer().unloadWorld(event.getPlayer().getWorld(), true);

        RespawnLocation = NewWorld.getSpawnLocation();

        event.getPlayer().teleport(RespawnLocation);
    }
}
