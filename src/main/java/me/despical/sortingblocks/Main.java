package me.despical.sortingblocks;

import me.despical.commandframework.CommandFramework;
import me.despical.sortingblocks.command.MainCommands;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Despical
 * <p>
 * Created at 1.07.2022
 */
public class Main extends JavaPlugin {

	private CommandFramework commandFramework;

	@Override
	public void onEnable() {
		initClasses();
	}

	private void initClasses() {
		this.commandFramework = new CommandFramework(this);

		new MainCommands(this);
	}

	public CommandFramework getCommandFramework() {
		return commandFramework;
	}
}