package client;

import cmds.ChopCommand;
import cmds.DuckCommand;
import interfaces.CookCommand;
import invoker.CookManager;
import invoker.Waiter;

public class RestaurantClient {

	public static void main(String[] args) {
		// 先要啟動背景，讓廚師都起來
		CookManager.runCookManager();
		// 用迴圈模擬多個桌號點餐
		for (int i = 0 ; i < 5; i++) {
			// 建立侍者
			Waiter waiter = new Waiter();
			// 建立指令物件 就是要點的菜
			CookCommand chop = new ChopCommand(i);
			CookCommand duck = new DuckCommand(i);
			// 點菜 就是讓侍者把菜記錄下來
			waiter.orderDish(chop);
			waiter.orderDish(duck);
			// 點菜完畢
			waiter.orderOver();
		}
	}

}
