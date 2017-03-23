package jiaowu;

import java.util.Random;
public class Tools{
	public String getCode(){
		char [] codeSequence= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
		Random random = new Random();
		StringBuilder sb = new StringBuilder();//动态字符串
		int count = 0;
		while(true){
			
			//产生一个随机下标
			char c = codeSequence[random.nextInt(36)];
			//假设取出字符在动态字符中不存在，代表没有重复的
			if(sb.indexOf(c+"")==-1){
				sb.append(c);
				count++;
				if(count == 4)
					break;
			}

		}
		return sb.toString();
	}
	
}