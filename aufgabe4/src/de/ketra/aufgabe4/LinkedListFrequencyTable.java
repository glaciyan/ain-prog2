package de.ketra.aufgabe4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    private int modCount = 0;

    public LinkedListFrequencyTable() {
        clear();
    }

    private static <T> Node<T> takeOut(Node<T> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = node.prev = null;
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.first = new Node<>(null, null, null);
        this.last = new Node<>(this.first, null, null);
        this.first.next = this.last;
        size = 0;
        modCount++;
    }

    @Override
    public void add(T w, int f) {
        Node<T> q = first.next;

        Node<T> lowerFrequencyNode = null;

        while (q.next != null) {
            if (q.element.getValue().equals(w)) {
                q.element.addFrequency(f);

                if (q.prev.element != null && q.element.getFrequency() >= q.prev.element.getFrequency()) {
                    Node<T> beforeSmallerNode = q.prev.prev;
                    Node<T> removed = remove(q);
                    while (beforeSmallerNode.prev != null) {
                        if (beforeSmallerNode.element.getFrequency() >= removed.element.getFrequency())
                            break;
                        beforeSmallerNode = beforeSmallerNode.prev;
                    }

                    insertAfter(removed.element.getValue(), removed.element.getFrequency(), beforeSmallerNode);
                }

                return;
            } else if (lowerFrequencyNode == null && f > q.element.getFrequency()) {
                lowerFrequencyNode = q;
            }

            q = q.next;
        }

        if (lowerFrequencyNode != null) {
            insertBefore(w, f, lowerFrequencyNode);
        } else {
            insertBefore(w, f, last);
        }
    }

    private Node<T> remove(Node<T> node) {
        Node<T> removed = takeOut(node);
        size--;
        modCount++;
        return removed;
    }

    private void insertBefore(T w, int f, Node<T> at) {
        Node<T> n = new Node<>(at.prev, at, new Element<>(w, f));
        n.prev.next = n;
        at.prev = n;
        size++;
        modCount++;
    }

    private void insertAfter(T w, int f, Node<T> at) {
        Node<T> n = new Node<>(at, at.next, new Element<>(w, f));
        at.next = n;
        n.next.prev = n;
        size++;
        modCount++;
    }

    @Override
    public Element<T> get(int pos) {
        if (pos < 0 || pos > size)
            throw new IndexOutOfBoundsException("%d is out of range with size %d".formatted(pos, size));

        Node<T> q = first.next;
        for (int i = 0; i < pos; i++) {
            q = q.next;
        }

        return q.element;
    }

    @Override
    public int get(T w) {
        Node<T> q = first.next;
        while (q.next != null) {
            if (q.element.getValue().equals(w)) return q.element.getFrequency();

            q = q.next;
        }

        return 0;
    }

    private static class Node<T> {

        public Node<T> prev;
        public Node<T> next;
        public Element<T> element;

        public Node(Node<T> prev, Node<T> next, Element<T> element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }

        @Override
        public String toString() {
            if (this.element == null) return "null word node";
            if (prev == null && next == null) {
                return "(%s:%d)".formatted(this.element.getValue(), this.element.getFrequency());
            }

            if (prev == null || prev.element == null) {
                return "(%s:%d) -> %s:%d".formatted(this.element.getValue(), this.element.getFrequency(), next.element.getValue(), next.element.getFrequency());
            } else if (next == null || next.element == null) {
                return "%s:%d -> (%s:%d) -> null".formatted(prev.element.getValue(), prev.element.getFrequency(), this.element.getValue(), this.element.getFrequency());
            } else {
                return "%s:%d -> (%s:%d) -> %s:%d".formatted(prev.element.getValue(), prev.element.getFrequency(), this.element.getValue(), this.element.getFrequency(), next.element.getValue(), next.element.getFrequency());
            }
        }
    }

    @Override
    public Iterator<Element<T>> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Element<T>> {
        private Node<T> current = first;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Element<T> next() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
            if(!hasNext())
                throw new NoSuchElementException();

            current = current.next;
            return current.element;
        }
    }
}
