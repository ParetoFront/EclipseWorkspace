

public class P004 {
	public static void main(String[] args) {
		P004 pp=new P004();
		String str="hello world today";
		System.out.println(pp.fun(str));
	}
	public String fun(String str) {
		char[] chs=str.toCharArray();
		int len=str.length();
		int count=0;
		for(int i=0;i<len;i++) {
			if(chs[i]==' ') {
				count++;
			}
		}
		int newLen=len+2*count;
		char[] newChs=new char[newLen];
		int left=len-1;
		int right=newLen-1;
		while(left>=0&&right>=0) {
			if(chs[left]==' ') {
				newChs[right--]='%';
				newChs[right--]='0';
				newChs[right--]='2';
				left--;
			}else {
				newChs[right--]=chs[left--];
			}
		}
		String a=new String(newChs);
		return a;
	}
}
