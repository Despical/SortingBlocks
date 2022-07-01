package me.despical.sortingblocks.command;

import me.despical.commandframework.Command;
import me.despical.commandframework.CommandArguments;
import me.despical.sortingblocks.Main;
import me.despical.sortingblocks.sort.ColumnBlocks;
import me.despical.sortingblocks.sort.algorithms.SelectionSort;
import me.despical.sortingblocks.sort.algorithms.ShuffleAlgorithm;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Despical
 * <p>
 * Created at 1.07.2022
 */
public class MainCommands {

	private List<ColumnBlocks> blocks;

	public MainCommands(Main plugin) {
		this.blocks = new ArrayList<>();

		plugin.getCommandFramework().registerCommands(this);
	}

	@Command(
			name = "sort",
			senderType = Command.SenderType.PLAYER
	)
	public void sortCommand(CommandArguments arguments) {
		new SelectionSort().sort(blocks.toArray(new ColumnBlocks[0]));
	}

	@Command(
			name = "wall",
			min = 1,
			senderType = Command.SenderType.PLAYER
	)
	public void wallCommand(CommandArguments arguments) {
		Player player = arguments.getSender();
		Location origin = player.getLocation().clone();
		int peak = arguments.getArgumentAsInt(0);

		List<ColumnBlocks> blocks = new ArrayList<>();

		for (int i = 1; i <= peak; i++) {
			blocks.add(new ColumnBlocks(origin.clone().add(i, 0, 0), i));
		}

		this.blocks = blocks;
	}

	@Command(
			name = "shuffle",
			senderType = Command.SenderType.PLAYER
	)
	public void shuffleCommand(CommandArguments arguments) {
		new ShuffleAlgorithm().sort(blocks.toArray(new ColumnBlocks[0]));
	}
}