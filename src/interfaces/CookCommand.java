package interfaces;

public interface CookCommand {
	/**
	 * 執行指令對應的操作
	 */
	public void execute();
	
	/**
	 * 設定指令的接收者
	 * @param cookApi 指令的接收者
	 */
	public void setCookApi(CookApi cookApi);
	/**
	 * 傳回發起請求的桌號 
	 * @return 發起請求的桌號
	 */
	public int getTableNum();
}
