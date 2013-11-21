package com.gmail.jameshealey1994.simpletowns.object;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.entity.Player;

/**
 * Class representing a Town.
 *
 * @author JamesHealey94 <jameshealey1994.gmail.com>
 */
public class Town {

    /**
     * The name of the Town.
     */
    private String name;

    /**
     * The usernames of the leaders of the Town.
     * A Player should only be a citizen or a leader, not both.
     */
    private Set<String> leaders = new HashSet<>();

    /**
     * The usernames of the citizens of the Town.
     * A Player should only be a citizen or a leader, not both.
     */
    private Set<String> citizens = new HashSet<>();

    /**
     * The TownChunks belonging to the Town.
     * A chunk should only belong to 1 Town at a time.
     */
    private Set<TownChunk> chunks = new HashSet<>();

    /**
     * Constructor - Initialises name, adds creator to leaders, and chunk to
     * chunks.
     *
     * @param name          the name of the Town
     * @param creator       the creator of the Town, normally the player that
     *                      sent the command
     * @param chunk         the first chunk in the town, normally the chunk that
     *                      the creator is standing in when creating the town
     */
    public Town(String name, String creator, TownChunk chunk) {
        this.name = name;
        this.leaders.add(creator);
        this.chunks.add(chunk);
    }

    /**
     * Constructor - Initialises all fields.
     *
     * @param name          the name of the Town
     * @param leaders       the leaders of the Town
     * @param citizens      the citizens of the Town
     * @param chunks        the TownChunks of the Town
     */
    public Town(String name, Set<String> leaders, Set<String> citizens, Set<TownChunk> chunks) {
        this.name = name;
        this.leaders = leaders;
        this.citizens = citizens;
        this.chunks = chunks;
    }

    /**
     * Returns the name of the Town.
     *
     * @return      the name of the Town
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Town.
     *
     * @param name      the new the name of the Town
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the usernames of the leaders of the Town.
     *
     * @return      the usernames of the leaders of the Town
     */
    public Set<String> getLeaders() {
        return leaders;
    }

    /**
     * Sets the usernames of the leaders of the Town.
     *
     * @param leaders       the new usernames of the leaders of the Town
     */
    public void setLeaders(Set<String> leaders) {
        this.leaders = leaders;
    }

    /**
     * Returns the usernames of the citizens of the Town.
     * Citizens are members of the Town but not leaders.
     *
     * @return      the usernames of the citizens of the Town
     */
    public Set<String> getCitizens() {
        return citizens;
    }

    /**
     * Sets the new usernames of the citizens of the Town.
     *
     * @param citizens      the new usernames of the citizens of the Town
     */
    public void setCitizens(Set<String> citizens) {
        this.citizens = citizens;
    }

    /**
     * Returns the set of TownChunks belonging to the Town.
     *
     * @return      the set of TownChunks belonging to the Town
     */
    public Set<TownChunk> getChunks() {
        return chunks;
    }

    /**
     * Sets the new set of TownChunks belonging to the Town.
     *
     * @param chunks        the new set of TownChunks belonging to the Town
     */
    public void setChunks(Set<TownChunk> chunks) {
        this.chunks = chunks;
    }

    /**
     * Returns if the passed Player is a member of the Town.
     * Members can be citizens or leaders
     *
     * @param player        player to be checked
     * @return              if the passed Player is a member of the Town
     */
    public boolean isMember(Player player) {
        return (getCitizens().contains(player.getName()) || getLeaders().contains(player.getName()));
    }
}