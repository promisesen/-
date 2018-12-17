package highCharts2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.alibaba.fastjson.JSON;
@WebServlet(value="/charts.do")
public class HighChartsServlet extends HttpServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//1�����ñ���
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//2���������ݿ������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from shopdata";
		ArrayList<ShopData> list = new ArrayList<ShopData>();
		//3����������ݿ����
		try {
			conn = ConnectionUtils.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ShopData s = new ShopData();
				s.setAge(rs.getString(1));
				ArrayList<Integer> data = new ArrayList<>();
				data.add(rs.getInt(2));
				data.add(rs.getInt(3));
				data.add(rs.getInt(4));
				data.add(rs.getInt(5));
				s.setData(data);
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4��JSON�Ĵ���
		String jsonStr = JSON.toJSON(list).toString();
		System.out.println(jsonStr);
		//5�����ݷ���ǰ̨
		res.getWriter().write(jsonStr);
	}
}
