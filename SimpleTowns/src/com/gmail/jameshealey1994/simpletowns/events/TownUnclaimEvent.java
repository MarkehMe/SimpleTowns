package com.gmail.jameshealey1994.simpletowns.events;

import com.gmail.jameshealey1994.simpletowns.object.Town;
import org.bukkit.Chunk;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Town Unclaim Event.
 * Triggered before a town removes a claim to a chunk.
 *
 * @author JamesHealey94 <jameshealey1994.gmail.com>
 */
public class TownUnclaimEvent extends Event implements Cancellable {

    /**
     * List of event handlers.
     */
    private static final HandlerList handlers = new HandlerList();

    /**
     * The town that is about to remove a claim to a chunk.
     */
    private final Town town;

    /**
     * The chunk the town is about to be unclaimed.
     */
    private final Chunk chunk;

    /**
     * The sender of the command.
     * May be an admin or the console.
     */
    private final CommandSender sender;

    /**
     * If the event is cancelled.
     */
    private boolean cancelled = false;

    /**
     * Constructor - Sets the member variables.
     *
     * @param town          town that is about to remove a claim to a chunk
     * @param chunk         chunk the town is about to be unclaimed
     * @param sender        sender of the command
     */
    public TownUnclaimEvent(Town town, Chunk chunk, CommandSender sender) {
        this.town = town;
        this.chunk = chunk;
        this.sender = sender;
    }

    /**
     * Returns list of event handlers.
     *
     * @return  list of event handlers
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Returns town that is about to remove a claim to a chunk.
     *
     * @return  the town that is about to remove a claim to a chunk
     */
    public Town getTown() {
        return town;
    }

    /**
     * Returns the chunk the town is about to be unclaimed.
     *
     * @return  chunk the town is about to be unclaimed
     */
    public Chunk getChunk() {
        return chunk;
    }

    /**
     * Returns the sender of the command.
     * May be an admin or the console.
     *
     * @return  sender of the command
     */
    public CommandSender getSender() {
        return sender;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}