package cmds;

import java.util.ArrayList;
import java.util.Collection;

import interfaces.CookApi;
import interfaces.CookCommand;
/**
 * 選單物件，是個巨集指令
 * @author User
 *
 */
public class MenuCommand implements CookCommand {

	private Collection<CookCommand> col = new ArrayList<CookCommand>();
	/**
	 * 點菜，把菜品加入選單
	 * @param cmd 菜品
	 */
	public void addCommand(CookCommand cmd) {
		col.add(cmd);
	}
	@Override
	public void execute() {
		// 執行選單就是把選單傳遞給後廚
		CommandQueue.addMenu(this);
	}
	@Override
	public void setCookApi(CookApi cookApi) {
		// do nothing
	}
	@Override
	public int getTableNum() {
		return 0;
	}
	/**
	 * 取得目前的選單所有指令
	 * @return 目前的選單所有指令
	 */
	public Collection<CookCommand> getCommands() {
		return this.col;
	}
	
	
}
