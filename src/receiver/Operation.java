package receiver;

import interfaces.OperationApi;

public class Operation implements OperationApi {
    /**
     *	紀錄運算結果 
     */
	private int result;
	@Override
	public int getResult() {
		return result;
	}

	@Override
	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public void add(int num) {
		// 實現加法功能
		result += num;
	}

	@Override
	public void substract(int num) {
		// 實現減法功能
		result -= num;
	}

}
