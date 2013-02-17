package random;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CSV {
	
	public static void main(String[] args) throws IOException {
		List<Integer>list=new ArrayList<Integer>();
		Random rd=new Random();
		//输入的数字
		Scanner sn = new Scanner(System.in);
		int n=Integer.valueOf(sn.next());
		boolean[] bool = new boolean[n];
		int num=0;
		//随机生成不重复的数字
		for(int i=0;i<n;i++){
			do{
				//如果产生的数相同继续循环
			num = rd.nextInt(n);    
			}while(bool[num]);
			if(num<1000000){
				bool[num] =true;
				list.add(num);
			}
		}
		//排序
		Collections.sort(list);
		List<Integer>arrayList=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			int par=(int)Math.pow(2, i);
			if(par<=list.size()){
				arrayList.add(list.get(list.get(par-1)));
			}
		}
	    //输出文件
	    File file=new File("D:\\10086.csv");
	    for(int m=0;m<arrayList.size();m++){
	    	String st=arrayList.get(m).toString();
	    	System.out.println(st);
	    	st+="\r\n";
	    	BufferedOutputStream os=null;
			OutputStream output=new FileOutputStream(file,true);
			os=new BufferedOutputStream(output);
			os.write(st.getBytes());
		    os.flush();
	    }
	}
}
