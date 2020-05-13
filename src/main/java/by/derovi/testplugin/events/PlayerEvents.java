package by.derovi.testplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

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

}
