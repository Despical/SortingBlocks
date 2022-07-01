package me.despical.sortingblocks.sort;

/**
 * @author Despical
 * <p>
 * Created at 1.07.2022
 */
public abstract class AbstractAlgorithm {

	protected boolean done;

	protected void setDone(boolean done) {
		this.done = done;
	}

	public boolean isDone() {
		return done;
	}

	public abstract void sort(ColumnBlocks[] blocks);

}