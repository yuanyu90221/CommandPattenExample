package interfaces;

public interface OperationApi {
	/***
	 * 獲得計算完成後的結果
	 * @return 計算完成後的結果
	 */
	public int getResult();
	/**
	 * 設定計算開始的初值
	 * @param result 計算開始的初值
	 */
	public void setResult(int result);
	/**
	 * 執行加法
	 * @param num 需要加的數
	 */
	public void add(int num);
	/**
	 * 執行減法
	 * @param num 需要減的數
	 */
	public void substract(int num);
}
