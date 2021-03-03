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
public class AddCommand implements Command {
	/**
	 * 持有實際執行計算的物件
	 */
	private OperationApi operation = null;
	/**
	 * 操作的資料
	 */
	private int opeNum;
	@Override
	public void execute() {
		// 呼叫接收者去真正執行功能，這個指令做加法
		this.operation.add(opeNum);
	}

	@Override
	public void undo() {
		// 呼叫接收者去真正執行功能，
		// 這個指令做加法，所以取消就是減法
		this.operation.substract(opeNum);
	}
	/**
	 * Constructor 傳入實際執行計算的物件
	 * @param operation 實際執行計算的物件
	 * @param opeNum 要加上的資料
	 */
	public AddCommand(OperationApi operation, int opeNum) {
		super();
		this.operation = operation;
		this.opeNum = opeNum;
	}

}
