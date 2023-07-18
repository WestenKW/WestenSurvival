package com.javasurvival.westensurvival;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WestenSurvival extends JavaPlugin {
    private String helpmessage;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("WestenSurvival has been enabled.");
        getServer().getPluginManager().registerEvents(new Welcome(), this);
        this.getCommand("helpme").setExecutor(this);

        FileConfiguration config = getConfig();

        helpmessage = config.getString("helpmessage");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("WestenSurvival has been disabled.");
    }

    public class Welcome implements Listener {
        // EventHandler
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent event) {
            Player player = event.getPlayer();
            String name = player.getName();

            Bukkit.broadcast(Component.text("Welcome to WestenSurvival, " + name + "!"));

        }
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        sender.sendMessage(Component.text(helpmessage));
        return true;
    }

 /*   public class HelpCommand implements CommandExecutor{
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

            sender.sendMessage(Component.text(helpmessage));
            return true;
        }

    }

  */
}


