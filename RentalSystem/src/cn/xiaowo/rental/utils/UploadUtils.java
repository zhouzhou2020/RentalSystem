package cn.xiaowo.rental.utils;

import java.util.UUID;
//上传工具类，用于房源信息上传初始化图片路径
public class UploadUtils {
	/**
	 * 获取随机名称
	 * @param realName 真实名称
	 * @return uuid
	 */
	public static String getUUIDName(String realName){
		//realname  可能是  1.jpg   也可能是  1
		//获取后缀名
		int index = realName.lastIndexOf(".");
		if(index==-1){
			return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		}else{
			return UUIDUtils.getId()+realName.substring(index);
		}
	}
	
	/**
	 * 获取文件真实名称
	 * @param name
	 * @return
	 */
	public static String getRealName(String name){
		// c:/upload/1.jpg    1.jpg
		//获取最后一个"/"
		int index = name.lastIndexOf("\\");
		return name.substring(index+1);
	}
	
	/**
	 * 获取文件目录
	 * @param name 文件名称
	 * @return 目录
	 */
	//保证任意文件存储的位置不同
	public static String getDir(String name){
		//任意一个对象都有一个hash码
		int i = name.hashCode();
		//将hash码转成16进制的字符串
		String hex = Integer.toHexString(i);
		int j=hex.length();
		for(int k=0;k<8-j;k++){
			hex="0"+hex;
		}
		return "/"+hex.charAt(0)+"/"+hex.charAt(1)+"/"+hex.charAt(2)+"/"+hex.charAt(3)+"/"+hex.charAt(4)+"/"+hex.charAt(5)+"/"+hex.charAt(6)+"/"+hex.charAt(7);
	}
	
	
}