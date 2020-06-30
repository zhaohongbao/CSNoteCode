package mycode.targeroffer;

//题解引用出处：https://cyc2018.github.io/CS-Notes/#/
//题目描述
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的 head。
//解题思路
//第一步，在每个节点的后面插入复制的节点。
//第二步，对复制节点的 random 链接进行赋值。
//第三步，拆分。

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/

public class Solution35 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        // 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }

    public static void main(String[] args) {
        Solution35 instance = new Solution35();
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        node1.next=node2;
        node1.random=node3;
        node2.next=node3;
        node2.random=node4;
        node3.next=null;
        node3.random=node1;
        node4.random=node2;
        node4.next=null;

        RandomListNode pCloneHead = instance.Clone(node1);
        RandomListNode cur = pCloneHead;
        while(cur!=null){
            System.out.print(cur.label+" ");
            cur=cur.next;
        }

    }

}
