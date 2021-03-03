package invoker;

import receiver.HotCook;
/**
 * 後廚管理類別
 * @author User
 *
 */
public class CookManager {
	/**
	 * 用來控制是否要在建立廚師，如果已經建立就不再建立
	 */
	private static boolean runFlag = false;
	public static void runCookManager() {
		if (!runFlag) {
			runFlag = true;
			// 建立三個廚師
			HotCook cook1 = new HotCook("張三");
			HotCook cook2 = new HotCook("李四");
			HotCook cook3 = new HotCook("王五");
			
			// 啟動他們的執行緒
			Thread t1 = new Thread(cook1);
			t1.start();
			Thread t2 = new Thread(cook2);
			t2.start();
			Thread t3 = new Thread(cook3);
			t3.start();
		}
	}
}
