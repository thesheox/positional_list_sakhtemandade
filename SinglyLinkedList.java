import java.util.Iterator;

import net.datastructures.Position;
import net.datastructures.PositionalList;

public class SinglyLinkedList<E> implements PositionalList<E> {

  private static class Node<E> implements Position<E> {

    
    private E element;           

 
    private Node<E> next;        

 
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

   
   
    public E getElement() throws IllegalStateException {
        if (next == null)                         
        throw new IllegalStateException("Position no longer valid");
        return element;
    }
 
    public Node<E> getNext() { return next; }

   
    public void setNext(Node<E> n) { next = n; }
  } 
  private Node<E> head = null;              

  
  private Node<E> tail = null;               



  private int size = 0;                      


  public SinglyLinkedList() { }             

  
  public int size() { return size; }

  
  public boolean isEmpty() { return size == 0; }

  


  public E removeFirst() {                   
    if (isEmpty()) return null;             
    E answer = head.getElement();
    head = head.getNext();                   
    size--;
    if (size == 0)
      tail = null;                          
    return answer;
  }




  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }


// @Override
// public Object getElement() throws IllegalStateException {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'getElement'");
// }


@Override
public Position<E> before(Position<E> p)   {
    Node<E> vorodi=(Node<E>)p;
    Node<E> n_head=head;
    while(n_head!=null){
        if(n_head==vorodi){
            return n_head;
        }
        n_head=n_head.getNext();
    }
    return null;

}


@Override
public Position<E> after(Position<E> p)  {
    Node<E> vorodi=(Node<E>)p;
    Node<E> n_head=vorodi.getNext();
    return n_head;
}


@Override
public Position<E> addBefore(Position<E> p, E e) {
   Node<E> vorodi=(Node<E>)p;
   Node<E> before_node=(Node<E>)before(p);
   Node<E> e_Node=new Node<E>(e,vorodi);
   before_node.next=e_Node;
   e_Node.next=vorodi;
   return e_Node;

}


@Override
public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addAfter'");
}


@Override
public E set(Position<E> p, E e) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'set'");
}


@Override
public E remove(Position<E> p) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
}


@Override
public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'iterator'");
}


@Override
public Iterable<Position<E>> positions() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'positions'");
}


@Override
public Position<E> first() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'first'");
}


@Override
public Position<E> last() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'last'");
}


@Override
public Position<E> addFirst(E e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addFirst'");
}


@Override
public Position<E> addLast(E e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addLast'");
}
}
