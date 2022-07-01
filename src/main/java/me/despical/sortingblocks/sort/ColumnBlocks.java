package me.despical.sortingblocks.sort;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Despical
 * <p>
 * Created at 1.07.2022
 */
public class ColumnBlocks {

	private final Location origin;
	private final List<Block> blocks;

	public ColumnBlocks(Location origin, int peak) {
		this.origin = origin;
		this.blocks = new ArrayList<>();

		setPeak(origin, peak);
	}

	public void setPeak(Location origin, int peak) {
		this.blocks.forEach(b -> b.setType(Material.AIR));
		this.blocks.clear();

		for (int y = 0; y < peak; y++) {
			Block block = origin.clone().add(0, y, 0).getBlock();
			block.setType(Material.STONE);

			blocks.add(block);
		}
	}

	public int getHeight() {
		return blocks.size();
	}

	public Location getOrigin() {
		return origin;
	}
}