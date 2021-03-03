package client;

import cmds.AddCommand;
import cmds.SubstractCommand;
import interfaces.OperationApi;
import invoker.Calculator;
import receiver.Operation;

public class Client {

	public static void main(String[] args) {
		// 1: 組裝指令跟接收者
		// 建立接收者
		OperationApi operation = new Operation();
		// 建立指令物件，並組裝指令和接收者
		AddCommand addCmd = new AddCommand(operation, 5);
		SubstractCommand substractCmd = new SubstractCommand(operation, 3);
		// 2: 把指令設定到持有者，也就是計算機裡面
		Calculator  calculator = new Calculator();
		calculator.setAddCmd(addCmd);
		calculator.setSubstractCmd(substractCmd);
		// 3: 模擬按下按鈕，測試一下
		calculator.addPressed();
		System.out.println("一次加法運算後的結果為:"+ operation.getResult());
		calculator.substractPressed();
		System.out.println("一次減法運算後的結果為:"+ operation.getResult());
		// 測試取消
		calculator.undoPressed();
		System.out.println("取消一次後的結果為:"+ operation.getResult());
		calculator.undoPressed();
		System.out.println("再取消一次後的結果為::"+ operation.getResult());
		// 測試恢復
		calculator.redoPressed();
		System.out.println("恢復一次後的結果為:"+ operation.getResult());
		calculator.redoPressed();
		System.out.println("再恢復一次後的結果為:"+ operation.getResult());
	}

}
