package datastructure.queue;

/**
 * datastructure.queue
 *
 * @author rj-liang
 * @date 2020/5/18 19:07
 */
public class EntryQueue {
    private Entry head;
    private Entry tail;

    synchronized void enqueue(Entry entry) {
        if (tail != null) {
            tail.next = entry;
            tail = entry;
        } else if (head == null) {
            head = tail = entry;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
        System.out.println("Head HashCode:" + head.hashCode());
        System.out.println("Tail HashCode:" + tail.hashCode());
        notifyAll();
    }

    synchronized Entry poll() {
        Entry entry = head;
        if (head != null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Current Head HashCode:" + entry.hashCode());
        }
        return entry;
    }
}
