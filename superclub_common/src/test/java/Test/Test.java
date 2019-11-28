package Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import com.xtkj.utils.keywordsfilter.FilteredResult;
import com.xtkj.utils.keywordsfilter.WordFilterUtil;

public class Test {

	public static void main(String[] args) throws IOException {

		//创建properties集合
		Properties prop=new Properties();
		//存储
		prop.setProperty("神奇的","4");
		//调试list显示在控制台上
		prop.list(System.out);

		//调用load将文件里的数据读取
		//prop=new Properties();
		//FileInputStream fis=new FileInputStream("C:\\Users\\Administrator\\Desktop\\bb.dict");
		//prop.load(fis);
		//prop.list(System.out);

		String str = "神奇的";
		FilteredResult result = WordFilterUtil.filterText(str, '*');
		//获取过滤后的内容
		System.out.println("替换后的字符串为:\n"+result.getFilteredContent());
		System.out.println("原始字符串为:\n"+result.getOriginalContent());
		//获取替换的敏感词
		System.out.println("替换的敏感词为:\n"+result.getBadWords());

		String prt=System.getProperty("user.dir");
		System.out.println(prt+"//src//words2.dict");
		
		//调用store存储到文件里  使用ISO-8859-1 字符编码
		FileOutputStream fos=new FileOutputStream(prt+"//src//words.dict",true);
		FileOutputStream fos1=new FileOutputStream(prt+"//bin//words.dict",true);
		//prop.store(fos,"追加");
		//prop.store(fos1,"追加");
		System.out.println(Test.class.getClassLoader().getResource("words2.dict"));
		
		prop.store(new OutputStreamWriter(fos, "UTF-8"), null);
		prop.store(new OutputStreamWriter(fos1, "UTF-8"), null);
	}
}
