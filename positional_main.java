

class positional_main
{
    public static void main(String[] args){
        PositionalSinglyLinkedList<Integer> p1=new PositionalSinglyLinkedList<Integer>();
        for(int i=0;i<10;i++){
            p1.addLast(i);
        }
        PositionalSinglyLinkedList.Node<Integer> node = new PositionalSinglyLinkedList.Node<>(3, null);
       
     p1.addBefore(p1.last(),12);
     p1.addAfter(p1.first(),22);
     p1.set(p1.first(), 33);
     p1.remove(p1.after(p1.first()));
    System.out.println(p1.before(p1.last()).getElement());
     System.out.println(p1.toString());
               
    }
}