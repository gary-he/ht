package cn.tarena.ht.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

//这是用来执行加密的工具类
public class Encrypt {
	
	public static String getMd5(String password,String username){
		
		return new Md5Hash(password, username, 3).toString();
	}
	
	public static void main(String[] args) {
		String password = new Md5Hash("admin", "admin", 3).toString();
		System.out.println(password);
	}
}
