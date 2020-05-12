package by.derovi.testplugin.commands;

import by.derovi.testplugin.utils.CommandManager;
import org.bukkit.command.CommandExecutor;

public abstract class Command implements CommandExecutor {
    public Command(String name) {
        this.name = name;
    }

    public String getArgumentInfo() {
        return "";
    }

    public String getHelp() {
        return getDescription();
    }

    public String getDescription() {
        return "";
    }

    public String getName() {
        return name;
    }

    private String name;
}
