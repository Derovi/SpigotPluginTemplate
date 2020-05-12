package by.derovi.testplugin;

import by.derovi.testplugin.commands.TestCommand;
import by.derovi.testplugin.events.PlayerEvents;
import by.derovi.testplugin.utils.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        registerCommands();
    }

    public static Plugin getInstance() {
        return instance;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    private void registerCommands() {
        commandManager = new CommandManager();
        commandManager.registerCommand(new TestCommand());
    }

    private static Plugin instance;
    private CommandManager commandManager;
}
