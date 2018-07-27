package nz.ssamjh.spigotplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotPlugin extends JavaPlugin {

    private static SpigotPlugin instance;

    public static SpigotPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("health-test")) {
            Player player = (Player) sender;
            Double playerHealth = player.getHealth();
            if (Person.getInstance().doubleNumber > 0D)
                player.sendMessage("Your health last time you ran the command was: " + String.format("%.2f", Person.getInstance().doubleNumber));
            else {
                player.sendMessage("This is the first time you are running the command so no history for you, cuck!");
            }

            Person.getInstance().doubleNumber = playerHealth;


            // player.sendMessage(String.format("%.2f", playerHealth));
            if (playerHealth < 2D) {
                player.setHealth(playerHealth + 8D);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a+4HP"));
            } else if (playerHealth < 4D) {
                player.setHealth(playerHealth + 6D);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a+3HP"));
            } else if (playerHealth < 6D) {
                player.setHealth(playerHealth + 4D);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a+2HP"));
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou have enough health so you get none!"));
            }
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("message-test")) {
            Player player = (Player) sender;

            String[][] wordGrid = {
                    {"&aHello, ", "&cmy ", "&aname ", "&cis: "},
                    {"&aSam ", "&cJohn ", "&aHowell, "},
                    {"&cand ", "&ayou ", "&call ", "&asuck&c!"}
            };
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lHELLO YOU SUCK! &a&lNO YOU DON'T, DON'T LISTEN TO HIM!"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[0][0] + wordGrid[0][1] + wordGrid[0][2] + wordGrid[0][3] + wordGrid[1][0] + wordGrid[1][1] + wordGrid[1][2] + wordGrid[2][0] + wordGrid[2][1] + wordGrid[2][2] + wordGrid[2][3]));
        }
        return false;
    }
}
