import java.util.Iterator;

import net.datastructures.Position;
import net.datastructures.PositionalList;

public class PositionalSinglyLinkedList<E> implements PositionalList<E> {

  public static class Node<E> implements Position<E> {

    
    private E element;           

 
    private Node<E> next;        

 
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

   
   
    public E getElement() throws IllegalStateException {
      
        return element;
    }
 
    public Node<E> getNext() { return next; }

   
    public void setNext(Node<E> n) { next = n; }
    private void setElement(E e) { element = e; }
  } 
  private Node<E> head = null;              

  
  private Node<E> tail = null;               



  private int size = 0;                      


  public PositionalSinglyLinkedList() { 

  }             

  
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
  private Position<E> position(Node<E> node) {
    
    return node;
  }



@Override
public Position<E> before(Position<E> p)   {
    Node<E> vorodi=(Node<E>)p;
    Node<E> n_head=head;
    while(n_head!=null){
        if(n_head.getNext()==vorodi){
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
  Node<E> vorodi=(Node<E>)p;
   Node<E> after_node=(Node<E>)after(p);
   Node<E> e_Node=new Node<E>(e,after_node);
   vorodi.next=e_Node;
   return e_Node;
}


@Override
public E set(Position<E> p, E e) throws IllegalArgumentException {
   Node<E> vorodi=(Node<E>)p;
  vorodi.setElement(e);
   
   return e;
}


@Override
public E remove(Position<E> p) throws IllegalArgumentException {
   Node<E> vorodi=(Node<E>)p;
    Node<E> after_node=(Node<E>)after(p);
   Node<E> before_node=(Node<E>)before(p);
   before_node.next=after_node;
   
   return vorodi.getElement();
}


@Override
public Iterator<E> iterator() {
    
    throw new UnsupportedOperationException("Unimplemented method 'iterator'");
}


@Override
public Iterable<Position<E>> positions() {
    
    throw new UnsupportedOperationException("Unimplemented method 'positions'");
}


@Override
public Position<E> first() {
  if (isEmpty()) return null;
  return position(head);
}


@Override
public Position<E> last() {
     if (isEmpty()) return null;
  return position(tail);
}


@Override
public Position<E> addFirst(E e) {
  head = new Node<E>(e, head);              
  if (size == 0)
    tail = head;                           
  size++;
  return head;
}


@Override
public Position<E> addLast(E e) {
  Node<E> newest = new Node<>(e, null);   
  if (isEmpty())
    head = newest;                        
  else
    tail.setNext(newest);                  
  tail = newest;                           
  size++;
  return newest;
}
}
