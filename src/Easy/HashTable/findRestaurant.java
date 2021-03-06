package Easy.HashTable;


/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 示例 1:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 *
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 马世臣 
 * @// TODO: 2020/2/5 599. 两个列表的最小索引总和 */


public class findRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map1=new HashMap<>();
        HashMap<String,Integer> map2=new HashMap<>();
        for (int i=0;i<list1.length;i++){
            map1.put(list1[i],i);
        }
        for (int i=0;i<list2.length;i++){
            map2.put(list2[i],i);
        }
        int min=Integer.MAX_VALUE;
        List<String> strings=new ArrayList<>();
        for (String s:list1){
            if(map2.containsKey(s)){
                if(map1.get(s)+map2.get(s)<min){
                    min=map1.get(s)+map2.get(s);
                    strings.clear();
                    strings.add(s);
                }else if(map1.get(s)+map2.get(s)==min){
                    strings.add(s);
                }
            }
        }
        String[] res=new String[strings.size()];
        for (int i=0;i<strings.size();i++) res[i]=strings.get(i);
        return res;
    }

    public String[] findRestaurant2(String[] list1, String[] list2) {
        if(list1.length>list2.length) return findRestaurant(list2, list1);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length && i <= min; i++) { // less execute in loop i <= min
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum < min) {
                    res.clear();
                    min = sum;
                    res.add(list2[i]);
                } else if (min == sum)
                    res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
    public static void main(String[] args) {

    }
}
