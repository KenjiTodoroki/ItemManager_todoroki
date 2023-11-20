package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ItemDAO;
import model.entity.ItemBean;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/item-detail")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemDetailServlet() {
		super();
	}

	/**
	 * GETリクエストを受け付けて、DBからデータを取得する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング（文字化けを防ぐ）
		request.setCharacterEncoding("UTF-8");
		
		// リクエストパラメータの取得
	    String itemId = request.getParameter("itemId"); // アイテムID
		
		String url = "item-detail.jsp"; // 転送用パスを格納する変数
		
		ItemDAO dao = new ItemDAO(); // ItemDAOクラスをインスタンス化
		
		// try-catchで例外処理
		try {
			// ItemDAOクラスのgetItemDetailメソッドを呼び出してユーザIDを取得
			ItemBean item = dao.getItemDetail(itemId);
			// リクエストスコープに保存する
			request.setAttribute("item", item);
			//リクエストスコープからインスタンスを取得する(item-detail.jsp)
//			ItemBean item = (ItemBean) request.getAttribute("item");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		// 各値を入れる為のリスト作成
//		ArrayList<String[]> list = new ArrayList<String[]>();
		// 読み込みたいSQL文を記述
//		String sql = "select\n"
//				+ "  mi.item_id,\n"
//				+ "  mi.item_name,\n"
//				+ "  mm.maker_name,\n"
//				+ "  mi.price,\n"
//				+ "  mi.insert_datetime,\n"
//				+ "  mi.update_datetime\n"
//				+ "from\n"
//				+ "  m_item mi\n"
//				+ "  inner join m_maker mm on mi.maker_code = mm.maker_code;";
		// try with resources & プリペアドステイトメントでConnectionManagerと連携
//		try (Connection con = ConnectionManager.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQLを実行
//			ResultSet rs = pstmt.executeQuery();
			// 時間フォーマットの設定
//			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 配列に各値を代入
//			while (rs.next()) {
//				String[] data = new String[6];
//				data[0] = String.valueOf(rs.getInt("mi.item_id"));
//				data[1] = rs.getString("mi.item_name");
//				data[2] = rs.getString("mm.maker_name");
//				data[3] = String.valueOf(rs.getInt("mi.price"));
//				data[4] = simpleDate.format(rs.getTimestamp("mi.insert_datetime"));
//				data[5] = simpleDate.format(rs.getTimestamp("mi.update_datetime"));
//				list.add(data);
//			}
		// 例外処理
//		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
//			System.out.println("例外発生:" + e.getMessage());
//			e.printStackTrace();
//		}
		// リクエストスコープへオブジェクト設定する
//		request.setAttribute("data", list);

		// 次の画面に遷移
//		ServletContext sc = getServletContext();
//		RequestDispatcher rd = sc.getRequestDispatcher("/item-detail.jsp");
//		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
