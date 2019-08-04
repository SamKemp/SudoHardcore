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

        String WorldName = "World-" + event.getPlayer().getDisplayName() + "-" + Hardcore.NoDeaths;

        event.getPlayer().getInventory().clear();

        World NewWorld = new WorldCreator(WorldName).generateStructures(true).type(WorldType.NORMAL).createWorld();
        NewWorld.setDifficulty(Difficulty.HARD);
        NewWorld.setKeepSpawnInMemory(false);

        if(!event.getPlayer().getWorld().getName().equalsIgnoreCase("world"))
            Bukkit.getServer().unloadWorld(event.getPlayer().getWorld(), true);

        Location RespawnLocation = NewWorld.getSpawnLocation();

        event.setRespawnLocation(RespawnLocation);
    }
}
