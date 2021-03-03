package interfaces;

public interface Command {
	/**
	 * 執行指令對應的操作
	 */
	public void execute();
	/**
	 * 執行取消指令對應的操作
	 */
	public void undo();
}
