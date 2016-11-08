
package LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        //Test load Linked List
        LinkedList<String> LL=new LinkedList<>();
        for (int i=0;i<10;++i)
        {
            LL.add(((Integer)i).toString());
        }
        LL.printList();
   

    }
}
