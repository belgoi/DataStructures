/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;


class Node<E>
{
    private E data;
    private Node<E> next;
    private Node<E> prev;
    Node(E data)
    {
        this.data=data;
        this.next=null;
        this.prev=null;
    }
    Node (E data,Node<E> next,Node<E> prev)
    {
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
    Node()
    {
        this.data=null;
        this.next=null;
        this.prev=null;
    }
    void setNext(Node next)
    {
        this.next=next;
    }
    void setPrev(Node prev)
    {
        this.prev=prev;
    }
    Node getPrev()
    {
        return prev;
    }
    Node getNext()
    {
        return next;
    }
    <E> E getData()
    {
        return (E) data;
    }
    void setData(E data)
    {
        this.data=data;
    }
}
