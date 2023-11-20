package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ItemEditDAO;
import model.dao.MakerDAO;
import model.entity.MakerBean;

/**
 * Servlet implementation class ItemEditServlet
 */
@WebServlet("/item-edit")
public class ItemEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemEditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "item-edit.jsp";
		
		MakerDAO dao = new MakerDAO();
		
		//データベースからメーカマスタの一覧を取得
		try {
			List<MakerBean> records = dao.getAllrecords();
			request.setAttribute("records", records); //一覧をセット
			// 例外キャッチ
		} catch (ClassNotFoundException | SQLException e) {

			//エラーメッセージをセット
			request.setAttribute("errorMessage", "SQL操作時に例外が発生しました。");
			e.printStackTrace();
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディング
	    request.setCharacterEncoding("UTF-8");
	    
	    //　リクエストパラメーターの取得
	    String itemName = request.getParameter("itemName");
	    String makerCode = request.getParameter("makerCode");
	    int price = Integer.parseInt(request.getParameter("price"));
	    
	    ItemEditDAO dao = new ItemEditDAO();
	    
	    try {
	    	dao.editItem(itemName, makerCode, price);
	    } catch (ClassNotFoundException | SQLException e) {
	    	request.setAttribute("例外：", e.getMessage());
		}
	
		String url = "item-detail";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
