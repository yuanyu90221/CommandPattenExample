/**
 * 
 */
package cmds;

import interfaces.Command;
import interfaces.OperationApi;

/**
 * @author User
 *
 */
public class SubstractCommand implements Command {
	/**
	 * 持有實際執行計算的物件
	 */
	private OperationApi operation = null;
	/**
	 * 操作的資料
	 */
	private int opeNum;
	/**
	 * Constructor 傳入實際執行計算的物件
	 * @param operation 實際執行計算的物件
	 * @param opeNum 要減去的資料
	 */
	public SubstractCommand(OperationApi operation, int opeNum) {
		this.operation = operation;
		this.opeNum = opeNum;
	}

	@Override
	public void execute() {
		// 呼叫接收者去真正執行功能，這個指令做減法
		this.operation.substract(opeNum);
	}

	@Override
	public void undo() {
		// 呼叫接收者去真正執行功能，
		// 這個指令做減法,所以取消就是加法
		this.operation.add(opeNum);
	}

}
