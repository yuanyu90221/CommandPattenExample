package receiver;

import cmds.CommandQueue;
import interfaces.CookApi;
import interfaces.CookCommand;
/**
 * 廚師物件，做熱菜
 * @author User
 *
 */
public class HotCook implements CookApi, Runnable {

	/**
	 * 廚師名
	 */
	private String name;
	
	public HotCook(String name) {
		this.name = name;
	}

	@Override
	public void cook(int tableNum, String name) {
		// 模擬不同的做菜時間
		int cookTime = (int) (20 * Math.random());
		System.out.println(this.name +"廚師正在為" + tableNum +"號桌做" + name);
		try {
			Thread.sleep(cookTime);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(this.name + "廚師為" + tableNum + "號桌做好了: " + name + "共耗時"+ cookTime + "秒");
	}

	@Override
	public void run() {
		while(true) {
			// 從指令Queue獲得指令物件
			CookCommand cmd = CommandQueue.getOneCommand();
			if (cmd != null ) {
				// 設定指令執行者
				cmd.setCookApi(this);
				// 執行指令
				cmd.execute();
			}
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	
}
