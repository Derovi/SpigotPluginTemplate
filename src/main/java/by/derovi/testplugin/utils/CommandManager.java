package by.derovi.testplugin.utils;

import by.derovi.testplugin.commands.Command;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Objects;

public class CommandManager {
    private HashMap<String, by.derovi.testplugin.commands.Command> commands = new HashMap<>();

    public by.derovi.testplugin.commands.Command getCommand(String name) {
        return commands.get(name);
    }

    public boolean isCommandExists(String name) {
        return commands.containsKey(name);
    }

    public void registerCommand(by.derovi.testplugin.commands.Command command) {
        commands.put(command.getName(), command);
        if (Bukkit.getPluginCommand(command.getName()) != null) {
            Objects.requireNonNull(Bukkit.getPluginCommand(command.getName())).setExecutor(command);
        }
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }
}
