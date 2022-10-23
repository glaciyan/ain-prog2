package de.ketra;

public class LinkedListFrequencyTable extends AbstractFrequencyTable {
    private static class Node {
        public Node prev;
        public Node next;
        public Word word;

        public Node(Node prev, Node next, Word word) {
            this.prev = prev;
            this.next = next;
            this.word = word;
        }

        @Override
        public String toString() {
            if (this.word == null) return "null word node";
            if (prev == null && next == null) {
                return "(%s:%d)".formatted(this.word.getWord(), this.word.getFrequency());
            }

            if (prev == null || prev.word == null) {
                return "(%s:%d) -> %s:%d".formatted(this.word.getWord(), this.word.getFrequency(), next.word.getWord(), next.word.getFrequency());
            } else if (next == null || next.word == null) {
                return "%s:%d -> (%s:%d) -> null".formatted(prev.word.getWord(), prev.word.getFrequency(), this.word.getWord(), this.word.getFrequency());
            } else {
                return "%s:%d -> (%s:%d) -> %s:%d".formatted(prev.word.getWord(), prev.word.getFrequency(), this.word.getWord(), this.word.getFrequency(), next.word.getWord(), next.word.getFrequency());
            }
        }
    }

    private Node first;
    private Node last;

    private int size;

    public LinkedListFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.first = new Node(null, null, null);
        this.last = new Node(this.first, null, null);
        this.first.next = this.last;
        size = 0;
    }

    @Override
    public void add(String w, int f) {
        Node q = first.next;

        while (q.next != null) {
            if (q.word.getWord().equals(w)) {
                q.word.addFrequency(f);

                if (q.prev != null && q.word.getFrequency() >= q.prev.word.getFrequency()) {
                    Node smallerNode = q.prev.prev;
                    Node removed = remove(q);
                    while (smallerNode.prev != null) {
                        if (smallerNode.word.getFrequency() >= removed.word.getFrequency())
                            break;
                        smallerNode = smallerNode.prev;
                    }

                    insertAfter(removed.word.getWord(), removed.word.getFrequency(), smallerNode);
                }

                return;
            }

            q = q.next;
        }

        insertBefore(w, f, last);
    }

    private static Node takeOut(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = node.prev = null;
        return node;
    }

    private Node remove(Node node) {
        Node removed = takeOut(node);
        size--;
        return removed;
    }

    private void insertBefore(String w, int f, Node at) {
        Node n = new Node(at.prev, at, new Word(w, f));
        n.prev.next = n;
        at.prev = n;
        size++;
    }

    private void insertAfter(String w, int f, Node at) {
        Node n = new Node(at, at.next, new Word(w, f));
        at.next = n;
        n.next.prev = n;
        size++;
    }

    @Override
    public Word get(int pos) {
        if (pos < 0 || pos > size)
            throw new IndexOutOfBoundsException("%d is out of range with size %d".formatted(pos, size));

        Node q = first.next;
        for (int i = 0; i < pos; i++) {
            q = q.next;
        }

        return q.word;
    }

    @Override
    public int get(String w) {
        Node q = first.next;
        while (q.next != null) {
            if (q.word.getWord().equals(w)) return q.word.getFrequency();

            q = q.next;
        }

        return 0;
    }
}
