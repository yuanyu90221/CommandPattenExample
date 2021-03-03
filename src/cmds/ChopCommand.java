package cmds;

import java.io.Serializable;

import interfaces.CookApi;
import interfaces.CookCommand;
/**
 * 指令物件，綠豆排骨煲
 * @author User
 *
 */
public class ChopCommand implements CookCommand, Serializable {
	/**
	 * 序列號
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 持有實際做菜的廚師物件
	 */
	private CookApi cookApi = null;
	/**
	 * 點菜的桌號
	 */
	private int tableNum;
	
	public ChopCommand(int tableNum) {
		this.tableNum = tableNum;
	}

	/**
	 * 設定實際做菜的廚師物件
	 * @param cookApi 實際做菜的廚師物件
	 */
	public void setCookApi(CookApi cookApi) {
		this.cookApi = cookApi;
	}

	public int getTableNum() {
		return this.tableNum;
	}
	@Override
	public void execute() {
		this.cookApi.cook(tableNum, "綠豆排骨煲");
	}

}
