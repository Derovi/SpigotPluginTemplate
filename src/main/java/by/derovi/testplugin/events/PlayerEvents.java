package by.derovi.testplugin.events;

import by.derovi.testplugin.Plugin;
import net.milkbowl.vault.Vault;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.logging.Level;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onEntityShoot(org.bukkit.event.entity.EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        player.setVelocity(event.getProjectile().getVelocity());
        event.getProjectile().remove();
    }

    @EventHandler
    public void onPlayerChat(org.bukkit.event.player.AsyncPlayerChatEvent event) {
        Bukkit.getLogger().log(Level.ALL, Plugin.getInstance().getEconomy() == null ? "Null" : "Not null");
        Bukkit.broadcastMessage( Plugin.getInstance().getEconomy() == null ? "Null" : "Not null");
        if (event.getMessage().matches("[Gg]ive\\s?me\\s?your\\s?money!+")) {
            Plugin.getInstance().getEconomy().depositPlayer(event.getPlayer(), 1);
        } else {
            Plugin.getInstance().getEconomy().depositPlayer(event.getPlayer(), -7);
            event.getPlayer().sendMessage("Debt for words!");
        }
    }

}
