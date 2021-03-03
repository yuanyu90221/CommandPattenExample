package interfaces;

public interface CookApi {
	/**
	 * 做菜
	 * @param tableNum 點菜的桌號
	 * @param name 菜名
	 */
	public void cook(int tableNum,String name);
}
