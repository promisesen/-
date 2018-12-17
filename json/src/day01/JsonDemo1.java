package day01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
@WebServlet(value="/json.do")
public class JsonDemo1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//拿到前台数据
		String data = req.getParameter("data");
		System.out.println(data);
		//把获取到的字符串类型的json数据进行转换成指定的对象
		//1.1、当前台的json字符串是一个javabean对象时
//		JSONObject jsonObject = JSONObject.parseObject(data);
//		System.out.println(jsonObject.getString("uid"));
//		System.out.println(jsonObject.getString("username"));
//		System.out.println(jsonObject.getString("password"));
//		//1.2、当前台的json字符串是一个javabean对象时，转成一个指定的java对象
//		User u = JSONObject.parseObject(data, User.class);
//		System.out.println(u);
		//2.当前台的json字符串是一个数组时
		ArrayList list = JSONObject.parseObject(data, new TypeReference<ArrayList>() {});
		System.out.println(list);
		//3.当前台的json字符串是一个javabean的数组的时候
		ArrayList<User> list1 = JSONObject.parseObject(data, new TypeReference<ArrayList<User>>() {});
		System.out.println(list1);
	}
}
