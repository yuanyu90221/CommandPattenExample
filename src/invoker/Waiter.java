package invoker;

import cmds.ChopCommand;
import cmds.DuckCommand;
import cmds.MenuCommand;
import cmds.PorkCommand;
import interfaces.CookApi;
import interfaces.CookCommand;
import receiver.CoolCook;
import receiver.HotCook;
/**
 * 侍者，負責組合菜單，並負責執行呼叫
 * @author User
 *
 */
public class Waiter {
	/**
	 * 持有一個巨集指令物件，選單
	 */
	private MenuCommand menuCmd = new MenuCommand();
	/**
	 * 客戶點菜
	 * @param cmd 菜單
	 */
	public void orderDish(CookCommand cmd) {
		// 把菜單加入 選單
		menuCmd.addCommand(cmd);
	}
	/**
	 * 客戶點完菜，代表要執行指令了
	 */
	public void orderOver() {
		this.menuCmd.execute();
	}
}
