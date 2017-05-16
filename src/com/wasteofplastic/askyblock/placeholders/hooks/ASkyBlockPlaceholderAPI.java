package com.wasteofplastic.askyblock.placeholders.hooks;

import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.wasteofplastic.askyblock.ASkyBlock;
import com.wasteofplastic.askyblock.placeholders.PlaceholderAPI;
import com.wasteofplastic.askyblock.placeholders.Placeholders;
import com.wasteofplastic.askyblock.placeholders.Placeholders.Placeholder;

/**
 * Common PlaceholderAPI for internal placeholders.
 * 
 * @author Poslovitch
 */
public class ASkyBlockPlaceholderAPI implements PlaceholderAPI{
	
	@Override
	public boolean register(ASkyBlock plugin) {
		return true;
	}

	@Override
	public void unregister(ASkyBlock plugin) {
		// Not needed here : it will make the placeholders don't work
	}

	@Override
	public String replacePlaceholders(Player player, String message) {
		if(message == null || message.isEmpty()){
			return "";
		}
		Bukkit.getLogger().info("DEBUG: " + player.getName() + " : " + message);
		for(Placeholder placeholder : Placeholders.getPlaceholders()){
		    Bukkit.getLogger().info("DEBUG: placeholder = " + placeholder.getIdentifier());
		    Bukkit.getLogger().info("DEBUG: replacement = " + placeholder.onRequest(player));
		    String textToFormat = "{" + placeholder.getIdentifier() + "}";
			message = message.replaceAll(Pattern.quote(textToFormat), placeholder.onRequest(player));
			Bukkit.getLogger().info("DEBUG: result = " + message);
		}
		return message;
	}

    @Override
    public String getName() {
        return "ASkyBlock";
    }

}
