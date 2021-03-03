package cmds;

import java.util.ArrayList;
import java.util.List;

import interfaces.CookCommand;
import util.FileOpeUtil;

public class CommandQueue {
	private final static String FILE_NAME = "CmdQueue.txt";

	/**
	 * 用來儲存指令物件的佇列
	 */
	private static List<CookCommand> cmds = null;
	static {
		cmds = FileOpeUtil.readFile(FILE_NAME);
		if (cmds == null) {
			cmds = new ArrayList<CookCommand>();
		}
	}
	/**
	 * 把菜單加入佇列
	 * @param menu 菜單
	 */
	public synchronized static void addMenu(MenuCommand menu) {
		for (CookCommand cmd : menu.getCommands()) {
			cmds.add(cmd);
		}
		FileOpeUtil.writeFile(FILE_NAME, cmds);
	}
	/**
	 * 廚師從佇列拿出菜單指令進行處理
	 * @return 菜單
	 */
	public synchronized static CookCommand getOneCommand() {
		CookCommand cmd =  null;
		if (cmds.size() > 0) {
			cmd = cmds.get(0);
			cmds.remove(0);
			FileOpeUtil.writeFile(FILE_NAME, cmds);
		}
		return cmd;
	}
}
