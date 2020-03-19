package Easy.LinkedListTest;


/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 **/

/**
 * @author 马世臣 
 * @// TODO: 2020/2/6 206. 反转链表 */

public class reverseList {


    public ListNode reverseList(ListNode head) {
        ListNode last=null;
        while (head!=null){
            ListNode temp=new ListNode(head.val);
            temp.next=last;
            last=temp;
            head=head.next;
        }
        return last;
    }
    
    public static void main(String[] args) {

    }
}
