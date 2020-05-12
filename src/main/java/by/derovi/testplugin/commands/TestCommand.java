package by.derovi.testplugin.commands;

import by.derovi.testplugin.Plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TestCommand extends by.derovi.testplugin.commands.Command {
    public TestCommand() {
        super("testplugin");
    }

    @Override
    public String getArgumentInfo() {
        return "[argument]";
    }

    @Override
    public String getDescription() {
        return "Use /testplugin to see information about available commands!";
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length == 0) {
            commandSender.sendMessage(getHelp());
            return true;
        }
        if (args[0].equals("help")) {
            if (args.length > 2) {
                commandSender.sendMessage(getDescription());
                return true;
            }
            if (args.length == 1) {
                commandSender.sendMessage(getHelp());
                return true;
            }
            if (Plugin.getInstance().getCommandManager().isCommandExists(args[1])) {
                commandSender.sendMessage(Plugin.getInstance().getCommandManager().getCommand(args[1]).getHelp());
                return true;
            }
            commandSender.sendMessage(getHelp());
            return true;
        }
        commandSender.sendMessage(getHelp());
        return true;
    }

    public String getHelp() {
        StringBuilder result = new StringBuilder("================= TestPlugin =================\n");
        for (by.derovi.testplugin.commands.Command command : Plugin.getInstance().getCommandManager().getCommands().values()) {
            result.append(command.getName());
            if (!command.getArgumentInfo().isEmpty()) {
                result.append(' ').append(command.getArgumentInfo()).append(' ');
            }
            if (!command.getDescription().isEmpty()) {
                result.append(" - ").append(command.getDescription());
            }
        }
        return result.toString();
    }
}
