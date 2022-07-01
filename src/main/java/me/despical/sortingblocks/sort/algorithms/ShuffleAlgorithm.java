package me.despical.sortingblocks.sort.algorithms;

import me.despical.sortingblocks.sort.AbstractAlgorithm;
import me.despical.sortingblocks.sort.ColumnBlocks;

import java.util.*;

/**
 * @author Despical
 * <p>
 * Created at 1.07.2022
 */
public class ShuffleAlgorithm extends AbstractAlgorithm {

	@Override
	public void sort(ColumnBlocks[] blocks) {
		Random random = new Random();
		ColumnBlocks temp;

		int index;

		for (int i = blocks.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = blocks[index];

			int indexHeight = blocks[index].getHeight(), iHeight = blocks[i].getHeight();

			blocks[index] = blocks[i];
			blocks[i] = temp;

			blocks[index].setPeak(blocks[index].getOrigin(), indexHeight);
			blocks[i].setPeak(blocks[i].getOrigin(), iHeight);
		}
	}
}