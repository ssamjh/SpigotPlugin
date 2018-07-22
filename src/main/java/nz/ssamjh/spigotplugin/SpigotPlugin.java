package nz.ssamjh.spigotplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("test")) {
            Player player = (Player) sender;
            Double playerHealth = player.getHealth();

            String[][] wordGrid = {
                    {"&aHello, ", "&cmy ", "&aname ", "&cis: "},
                    {"&aSam", "&cJohn", "&aHowell, "},
                    {"&cand ", "&ayou ", "&call ", "&asuck&c!"}
            };

            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[0][0]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[0][1]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[0][2]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[0][3]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[1][0]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[1][1]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[1][2]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[2][0]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[2][1]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[2][2]));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', wordGrid[2][3]));

            player.sendMessage(String.format("%.2f", playerHealth));
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
        } else if (cmd.getName().equalsIgnoreCase("test")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command may only be executed by a player");
            }

        }
        return false;
    }
}
