/*
* implements a doubly linked list 
* each node has a reference to the node in front of it and to the node behind it
* a head node and tail node are used to keep track of the beginning and end of the list
*/ 
package LinkedList;
import java.util.AbstractList;

public class LinkedList<E> extends AbstractList<E>
{
    private int size;
    private Node<E> head;
    private Node<E> tail;
    public LinkedList()
    {
        size=0;
        head=new Node();
        tail=new Node();
        head.setNext(tail);
        tail.setPrev(head);
    }
    public boolean add(E data)
    {
        //adds an element at the end of the list
        if (data == null)
            throw new NullPointerException();
        else
        {
            Node<E> newNode = new Node(data,tail,tail.getPrev());
            tail.getPrev().setNext(newNode);
            tail.setPrev(newNode);
            
            ++size;
        }
        return true;
    }
    public int size()
    {
        return size;
    }
    public E remove(int index)
    {
        //removes element at index and returns 
        //the data that was removed 
        Node<E> tempNode=new Node();
        if (index <size && index >=0)
        {
            tempNode=getNode(index);
            tempNode.getPrev().setNext(tempNode.getNext());
            tempNode.getNext().setPrev(tempNode.getPrev());
            tempNode.setNext(null);
            tempNode.setPrev(null);
            --size;
        }
        else
            throw new IndexOutOfBoundsException();
        
        return tempNode.getData();
    }
    public void add(int index,E data)
    {
        //Adds an element to the linked list at the index
        if (data==null)
            throw new NullPointerException();
        if (index==0)
        {
            Node<E> newNode=new Node(data,head.getNext(),head);
            head.getNext().setPrev(newNode);
            head.setNext(newNode);
        }
        else
        {
            Node<E> tempNode = new Node();
            tempNode=getNode(index-1);
            
            Node<E> newNode= new Node(data,tempNode.getNext(),tempNode);
            tempNode.getNext().setPrev(newNode);
            tempNode.setNext(newNode);
        }
        ++size;
        
    }
    public E get(int index)
    {
        //return value at index
        //if index is out of bounds then an exception is thrown
        if (index >=0 && index <size)
            return getNode(index).getData();
        else
            throw new IndexOutOfBoundsException();
    }
    public E set(int index,E data)
    {
        //set the value at index and returns the value that was replaced
        //if index is out of bounds then an exception is thrown
        Node<E> node=new Node();
        E prevValue;
        if (index >= 0 && index <size)
        {
            node=getNode(index);
            prevValue=node.getData();
            node.setData(data);
        }
        else
            throw new IndexOutOfBoundsException();
        return prevValue;
    }
    private Node<E> getNode(int index)
    {
        //private helper method.  
        //returns a given node.  Should never have to used outside of the class
        Node<E> node=new Node();
        int i=0;
        if (index >=0)
        {           
            node=head; 
            while(i<=index)
            {
                if(node==tail)
                    throw new IndexOutOfBoundsException();
                else
                {
                    node=node.getNext();
                    i++;
                }
            }
        }
        else
            throw new IndexOutOfBoundsException();
        
        return node;
    }
    public void printList()
    {
        Node<E> node=new Node();
        for (int i=0;i<size;++i)
        {
            node=getNode(i);
            System.out.println((E)node.getData());
        }
    }
    
}
