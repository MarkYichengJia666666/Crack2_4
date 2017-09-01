/**
 * Created by jiayicheng on 17/7/19.
 */
public class Partition {
    class Node{
        int data;
        Node next;
        public Node(int d)
        {
            data=d;
        }
        void appendToTail(int d)
        {
            Node end=new Node(d);
            Node n=this;
            while(n.next!=null)
            {
                n=n.next;
            }
            n.next=end;
        }
    }
   //目的：把小于一个数值的链表元素放左面，大于等于的放右面
    //方法：创建两个链表，一个存放小的，一个存放大的，直到所有元素都过完，合在一起。
    Node Partition1(Node head,int k)
    {
        Node beforeStart=null;
        Node beforeEnd=null;
        Node afterStart=null;
        Node afterEnd=null;

        while(head!=null)
        {
            Node n=head.next;   //给这个链表换个头
            head.next=null;     //先把这个元素孤立出来，好进行下一步的操作.非常重要！！！！！！

            if(head.data<k)
            {
                if(beforeStart==null)
                {
                    beforeStart=head;
                    beforeEnd=beforeStart;
                }else
                {
                    beforeEnd.next=head;
                    beforeEnd=head;
                }
            }
            else
                {
                if(afterStart==null)
                {
                    afterStart=head;
                    afterEnd=afterStart;
                }
                else
                {
                    afterEnd.next=head;
                    afterEnd=head;
                }
            }
            head=n;        //进行下一步循环
        }
        if(beforeStart==null)
            return afterStart;
        if(afterStart==null)
            return beforeStart;
        beforeEnd.next=afterStart;
        return beforeStart;
    }




    Node Partition2(Node n,int k)
    {
        Node head=n;
        Node tail=n;   //n是开头，作为中间那个元素，它可以属于任何一边，投机取巧。
        while(n!=null)
        {
            Node next=n.next;
            if(n.data<k)
            {
                n.next=head;
                head=n;
            }else
            {
                tail.next=n;
                tail=n;
            }
            n=next;
        }
        tail.next=null;    //结尾收一下
        return head;       //输出整个链表。
    }
}
