package P003_LongestString;
//用arraylist实现。arraylist集合的底层是用一个数组来存储元素，在增加或删除指定位置的
//元素时会导致创建新的数组，效率较低，因此不适合大量的增删操作。
//但这种数组的结构运行程序通过索引的方式访问元素，因此使用arraylist查找元素很方便
//另外，arraylist的remove方法要注意，因为删除一个元素后list长度缩短了，若用remove（i），随着删除进行，i可能会超出当前长度导致出错

import java.util.ArrayList;

public class P003_solution3 {
    public static void main(String[] args) {
        System.out.println(new P003_solution3().findLongestString("abccabdddd"));
    }

    private int findLongestString(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        int len = s.length();
        int longest = 0;
        int i = 0;
        int j = 0;
        while (j < len) {
            if (!arr.contains(s.charAt(j))) {
                arr.add(s.charAt(j++));
                longest = Math.max(longest, j - i);

            } else {
                //删除的arr的第一个字母，所以用arr.remove(0)，而不是用remove(i)
                arr.remove(0);
                i++;
            }
        }
        return longest;
    }
}

