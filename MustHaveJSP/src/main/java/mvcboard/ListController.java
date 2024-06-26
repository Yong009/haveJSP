package mvcboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.BoardPage;

public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


		MVCBoardDAO dao = new MVCBoardDAO();

		Map<String, Object> map = new HashMap<String, Object>();

		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		if(searchWord != null) {
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		int totalCount = dao.selectCount(map);


		ServletContext application = getServletContext();
		int pageSize = 10;
		int blockPage = 5;

		int pageNum = 1;
		String pageTemp = req.getParameter("pageNum");
		if(pageTemp != null && !pageTemp.equals(""))
			pageNum = Integer.parseInt(pageTemp);


		int start = (pageNum -1 ) * pageSize + 1;
		int end = pageNum * pageSize;
		map.put("start",start);
		map.put("end", end);

		List<MVCBoardDTO> boardLists = dao.selectListPage(map);

		dao.close();


		String pagingImg = BoardPage.PagingStr(totalCount, pageSize, blockPage, pageNum, "/mvcboard/list.do");
		map.put("pagingImg",pagingImg);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);

		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map", map);
		req.getRequestDispatcher("/List2.jsp").forward(req, resp);



	}
}
