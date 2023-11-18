package test;

import java.sql.SQLException;
import java.util.Arrays;

import model.dao.UserDAO;
import model.entity.UserBean;

public class Test {

	public static void main(String[] args) {
		//		try {
		//			Connection con = ConnectionManager.getConnection();
		//			System.out.println("接続成功");
		//		} catch (ClassNotFoundException | SQLException e) {
		//			e.printStackTrace();
		//			System.out.println("接続失敗");
		//		}
		UserBean user = new UserBean();

		user.setUserId("中村");
		user.setPassword("小屋町");

		System.out.println(user.getUserId());
		System.out.println(user.getPassword());

		UserBean user2 = new UserBean();

		user2.setUserId("hama");
		user2.setPassword("ootomo");

		System.out.println(user2.getUserId());
		System.out.println(user2.getPassword());

		UserDAO dao = new UserDAO();

		try {
			user = dao.checkLogin("user", "password");

			if (user != null) {
				System.out.println("ログイン成功");
			} else {
				System.out.println("ログイン失敗");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("接続失敗");
		}

		System.out.println(user.getUserId());
		System.out.println(user.getPassword());

		// 結果1
		introduce();
		System.out.println("------------------------------------");
		// 結果2
		introduce2("山田太郎");
		System.out.println();
		System.out.println("------------------------------------");
		// 結果3
		introduce3("山田太郎", 25);
		System.out.println("------------------------------------");
		// 結果4
		int result = multiply(3, 2);

		System.out.println("1つ目の引数：3");
		System.out.println("2つ目の引数：2");
		System.out.println("乗算結果：" + result);
		System.out.println("------------------------------------");
		// 結果5
		int result2 = triangle(6, 5);

		System.out.println("底辺：6");
		System.out.println("高さ：5");
		System.out.println("三角形の面積：" + result2);
		System.out.println("------------------------------------");
		// 結果6
		double result3 = circle(3);

		System.out.println("半径：3");
		System.out.println("円の面積：" + result3);
		System.out.println("------------------------------------");
		// 結果7
		int result4 = sumloop(1, 100);

		System.out.println("最小値：1");
		System.out.println("最大値：100");
		System.out.println("加算結果：" + result4);
		System.out.println("------------------------------------");
		// 結果8
		String[] fruitsList = getFruits();

		System.out.println("フルーツ一覧：" + Arrays.toString(fruitsList));
		System.out.println("------------------------------------");
		// 結果9
		timesTable();
	}

	// メソッド定義
	// public 戻り値の型 メソッド名(引数) {
	// 処理
	//	}

	// 練習1
	public static void introduce() {
		System.out.println("私の名前は山田太郎です。");
	}

	// 練習2
	public static void introduce2(String name) {
		System.out.printf("私の名前は%sです。", name);
	}

	// 練習3
	public static void introduce3(String name, int age) {
		System.out.println("私の名前は" + name + "です。年齢は" + age + "歳です。");
	}

	// 練習4
	public static int multiply(int number1, int number2) {
		int sum = number1 * number2;

		return sum;
	}

	// 練習5
	public static int triangle(int base, int height) {
		int triangleArea = base * height / 2;

		return triangleArea;
	}

	// 練習6
	public static double circle(double radius) {
		double circleArea = radius * radius * 3.14;

		return circleArea;
	}

	// 練習7
	public static int sumloop(int min, int max) {
		int sum = 0;

		for (int i = min; i <= max; i++) {
			sum += i;

		}
		return sum;
	}

	// 練習8
	public static String[] getFruits() {
		String[] fruits = { "りんご" + "、" + "バナナ" + "、" + "ぶどう" + "、" + "キウイ" + "、" + "もも" };

		return (fruits);
	}

	// 総合練習1
	public static void timesTable() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%3d", i * j);
			}
			System.out.println();
		}
	}

}
