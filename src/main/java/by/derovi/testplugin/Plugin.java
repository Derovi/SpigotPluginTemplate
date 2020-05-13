package by.derovi.testplugin;

import by.derovi.testplugin.commands.TestCommand;
import by.derovi.testplugin.events.PlayerEvents;
import by.derovi.testplugin.utils.CommandManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Plugin extends JavaPlugin {
    private static Plugin instance;

    private Economy economy;

    private CommandManager commandManager = new CommandManager();

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        registerCommands();
        setupEconomy();
    }

    private void registerCommands() {
        commandManager.registerCommand(new TestCommand());
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer()
                .getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    public static Plugin getInstance() {
        return instance;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public Economy getEconomy() {
        return economy;
    }
}
