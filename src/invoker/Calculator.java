package invoker;

import java.util.ArrayList;
import java.util.List;

import interfaces.Command;

public class Calculator {
	/**
	 * 指令的操作歷史紀錄，在取消時候用
	 */
	private List<Command> undoCmds = new ArrayList<Command>();
	/**
	 * 指令被取消的歷史紀錄，在恢復時候用
	 */
	private List<Command> redoCmds = new ArrayList<Command>();
	/**
	 * 加法指令
	 */
	private Command addCmd = null;
	/**
	 * 減法指令
	 */
	private Command substractCmd = null;
	/**
	 * 設定加法指令
	 * @param addCmd 加法指令
	 */
	public void setAddCmd(Command addCmd) {
		this.addCmd = addCmd;
	}
	/**
	 * 設定減法指令
	 * @param substractCmd 減法指令
	 */
	public void setSubstractCmd(Command substractCmd) {
		this.substractCmd = substractCmd;
		// 把操作記錄到歷史紀錄
		undoCmds.add(this.addCmd);
	}
	/**
	 * 客戶呼叫加法指令
	 */
	public void addPressed() {
		this.addCmd.execute();
	}
	/**
	 * 客戶呼叫減法指令
	 */
	public void substractPressed() {
		this.substractCmd.execute();
		// 把操作記錄到歷史紀錄
		undoCmds.add(this.substractCmd);
	}
	public void undoPressed() {
		if (this.undoCmds.size() > 0) {
			// 取出最後一個指令來取消
			Command cmd = this.undoCmds.get(undoCmds.size() - 1);
			cmd.undo();
			// 如果還有恢復功能就把這個指令紀錄到恢復的歷史紀錄
			this.redoCmds.add(cmd);
			// 把最後一個指令刪除
			this.undoCmds.remove(cmd);
		} else {
			System.out.println("Sorry, No Undoable Commands");
		}
	}
	public void redoPressed() {
		if (this.redoCmds.size() > 0) {
			// 取出最後一個指令來恢復
			Command cmd = this.redoCmds.get(redoCmds.size() - 1);
			cmd.execute();
			// 把指令紀錄到可以取消的歷史紀錄裡
			this.undoCmds.add(cmd);
			// 把最後一個指令刪除
			this.redoCmds.remove(cmd);
		} else {
			System.out.println("Sorry, No redoable Commands");
		}
	}
}
