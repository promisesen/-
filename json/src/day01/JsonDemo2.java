package day01;

import java.util.ArrayList;
import java.util.Collections;

import com.alibaba.fastjson.JSON;

public class JsonDemo2{
	public static void main(String[] args) {
//		javabean2json();
		//当后台的数据是一个集合或者数组的话
		ArrayList<User> list = new ArrayList<User>();
		Collections.addAll(list, new User(1001,"zhangsan","123456"),
				new User(1002,"lisi","123456"),
				new User(1003,"wangwu","123456"));
		//进行转码
		Object obj = JSON.toJSON(list);
		System.out.println(obj.toString());
	}

	private static void javabean2json() {
		//当后台的数据是对象时
		//1、创建对象
		User u = new User(1001,"zhangsan","123456");
		//2、使用fastjson来进行编码，把对象转为json字符串的格式
		Object obj = JSON.toJSON(u);
		System.out.println(obj.toString());
	}
}
