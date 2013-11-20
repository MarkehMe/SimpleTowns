package com.gmail.jameshealey1994.simpletowns.listeners;

import com.gmail.jameshealey1994.simpletowns.SimpleTowns;
import com.gmail.jameshealey1994.simpletowns.object.Town;
import com.gmail.jameshealey1994.simpletowns.object.TownChunk;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Listener class for SimpleTowns plugin.
 *
 * @author JamesHealey94 <jameshealey1994.gmail.com>
 */
public class SimpleTownsListener implements Listener {

    /**
     * Plugin associated with the Listener.
     */
    SimpleTowns plugin;

    /**
     * Constructor - Initialises associated plugin.
     *
     * @param plugin    plugin associated with the listener
     */
    public SimpleTownsListener(SimpleTowns plugin) {
        this.plugin = plugin;
    }

    /**
     * Checks the player is allowed to break the block.
     *
     * @param event     event being handled
     */
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final Chunk chunk = event.getBlock().getChunk();
//        plugin.getServer().getWorld("").getChunkAt();

        for (Town t : plugin.getTowns()) {
            for (TownChunk c : t.getChunks()) {
                if (chunk.equals(c)) { // TODO - Override TownChunk .equals so it works with Chunk?
                    if (t.getCitizens().contains(player.getName()) || t.getLeaders().contains(player.getName())) {
                        break;
                    } else {
                        player.sendMessage("You aren't allowed to build here!"); // TODO - Change
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    /**
     * Checks the player is allowed to place the block.
     *
     * @param event     event being handled
     */
    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final Chunk chunk = event.getBlockAgainst().getChunk();

        for (Town t : plugin.getTowns()) {
            for (TownChunk c : t.getChunks()) {
                if (chunk.equals(c)) {
                    if (t.getCitizens().contains(player.getName()) || t.getLeaders().contains(player.getName())) {
                        break;
                    } else {
                        player.sendMessage("You aren't allowed to build here!"); // TODO - Change
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}