package DataStructs.Bags;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * *不允许移除元素的集合(只允许collect和iterate)
 */
public class Bag<Element> implements Iterable<Element> {

    private Node<Element> firstElement;
    private int size;

    private class Node<Elememt>{
        private Element content;
        private Node<Elememt> nextElement;
    }

    public Bag(){
        firstElement = null;
        size = 0;
    }

    public int size(){
        return size;

    }

    public void add(Element element){
        Node<Element> oldfirst  =firstElement;
        firstElement  =new Node<Element>();
        firstElement.content = element;
        firstElement.nextElement = oldfirst;
        size++;
    }

    public boolean contains(Element element){
        Iterable<Element> interator = (Iterable<Element>) this.iterator();
        while(iterator().hasNext()){
            return true;
        }
        return false;
    }



    private class ListIterator<Element> implements Iterator<Element>{

        private Node<Element> currentElement;

        public ListIterator(Node<Element> firstElement){
            currentElement = firstElement;
        }

        @Override
        public boolean hasNext() {
            return currentElement!=null;

        }

        @Override
        public Element next() {
            if(!hasNext()){
                throw new NoSuchElementException();
                Element element = (Element) currentElement.content;
                currentElement = currentElement.nextElement;
                return element;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();

        bag.add("a");
        bag.add("a");
        bag.add("b");

        System.out.println("size of bag = "+bag.size());
        for(String s:bag){
            System.out.println(s);
        }

        System.out.println(bag.contains(null));
        System.out.println(bag.contains("a"));
        System.out.println(bag.contains("b"));
        System.out.println(bag.contains("c"));
    }
}













