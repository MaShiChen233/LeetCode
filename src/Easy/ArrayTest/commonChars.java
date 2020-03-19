package Easy.ArrayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 **/

/**
 * @author 马世臣 
 * @// TODO: 2020/2/4 1002. 查找常用字符 */

public class commonChars {


    public List<String> commonChars(String[] A) {
        int[] bucket=new int[26];
        List<String> list=new ArrayList<>();
        for (char c:A[0].toCharArray())  bucket[c-'a']++;
        for (int i=1;i<A.length;i++){
            int[] temp=new int[26];
            for (char c:A[i].toCharArray()) temp[c-'a']++;
            for (int j=0;j<temp.length;j++) bucket[j]=Math.min(bucket[j],temp[j]);
        }
        for (int i=0;i<bucket.length;i++){
            for (int j=0;j<bucket[i];j++)   list.add(""+(char) (i+'a'));
        }
        return list;
    }
    
    public static void main(String[] args) {
        String[] strings=new String[]{"bella","label","roller"};
        System.out.println(new commonChars().commonChars(strings));
    }
}
