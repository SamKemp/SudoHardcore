package live.samkemp.plugin.hardcore.hardcore;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class MyListeners implements Listener
{

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        Hardcore.NoDeaths++;

        String WorldName = Hardcore.RunKey + "_World-" + event.getPlayer().getDisplayName() + "-" + Hardcore.NoDeaths;

        event.getPlayer().getInventory().clear();

        World NewWorld = new WorldCreator(WorldName).generateStructures(true).type(WorldType.NORMAL).environment(World.Environment.NORMAL).createWorld();
        NewWorld.setDifficulty(Difficulty.HARD);
        NewWorld.setKeepSpawnInMemory(false);

        if(!event.getPlayer().getWorld().getName().equalsIgnoreCase("world"))
            Bukkit.getServer().unloadWorld(event.getPlayer().getWorld(), true);

        Location RespawnLocation = NewWorld.getSpawnLocation();

        event.setRespawnLocation(RespawnLocation);

        new WorldCreator(WorldName + "_nether").generateStructures(true).type(WorldType.NORMAL).environment(World.Environment.NETHER).createWorld();
        new WorldCreator(WorldName + "_end").generateStructures(true).type(WorldType.NORMAL).environment(World.Environment.THE_END).createWorld();
    }

    @EventHandler
    public void playerEnterPortal(PlayerPortalEvent event)
    {
        String WorldName = Hardcore.RunKey + "_World-" + event.getPlayer().getDisplayName() + "-" + Hardcore.NoDeaths;
        Location PortalTo;
        String GoingTo = event.getTo().getWorld().getName();

        if(GoingTo.equalsIgnoreCase("world_nether"))
        {
            PortalTo = Bukkit.getServer().getWorld(WorldName + "_nether").getSpawnLocation();
        }
        else if(GoingTo.equalsIgnoreCase("world_end"))
        {
            PortalTo = Bukkit.getServer().getWorld(WorldName + "_end").getSpawnLocation();
        }
        else if(GoingTo.equalsIgnoreCase("world"))
        {
            PortalTo = Bukkit.getServer().getWorld(WorldName).getSpawnLocation();
        }
        else
        {
            PortalTo = Bukkit.getServer().getWorld(WorldName).getSpawnLocation();
        }

        event.setTo(PortalTo);
    }
}
