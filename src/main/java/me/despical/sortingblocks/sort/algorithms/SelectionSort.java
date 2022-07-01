package me.despical.sortingblocks.sort.algorithms;

import me.despical.sortingblocks.sort.AbstractAlgorithm;
import me.despical.sortingblocks.sort.ColumnBlocks;

/**
 * @author Despical
 * <p>
 * Created at 1.07.2022
 */
public class SelectionSort extends AbstractAlgorithm {

	@Override
	public void sort(ColumnBlocks[] blocks) {
		for (int i = 0; i < blocks.length; i++) {

			int index = i;

			for (int j = i + 1; j < blocks.length; j++) {
				int jHeight = blocks[j].getHeight(), indexHeight = blocks[index].getHeight();

				if (jHeight < indexHeight) {
					index = j;
				}
			}

			ColumnBlocks smallerNumber = blocks[index];

			int indexHeight = blocks[index].getHeight(), iHeight = blocks[i].getHeight();

			blocks[index] = blocks[i];
			blocks[i] = smallerNumber;

			blocks[index].setPeak(blocks[index].getOrigin(), indexHeight);
			blocks[i].setPeak(blocks[i].getOrigin(), iHeight);
		}
	}
}