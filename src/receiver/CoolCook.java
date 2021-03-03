package receiver;

import interfaces.CookApi;
/**
 * 廚師物件，做涼菜
 * @author User
 *
 */
public class CoolCook implements CookApi {
	/**
	 * 廚師名
	 */
	private String name;
	
	public CoolCook(String name) {
		this.name = name;
	}

	@Override
	public void cook(int tableNum, String name) {
		System.out.println("涼菜" + name + "已經做好， 廚師" + this.name + "正在裝盤");
	}

}
