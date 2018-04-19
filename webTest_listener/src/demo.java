import java.io.UnsupportedEncodingException;

public class demo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a="你好";
		byte[] bytes=a.getBytes("utf-8");
		System.out.println(bytes);
		
		String b=new String(bytes,"utf-8");
		System.out.println(b);
	}
}
