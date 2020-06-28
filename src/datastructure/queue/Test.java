package datastructure.queue;

/**
 * datastructure.queue
 *
 * @author rj-liang
 * @date 2020/5/18 19:07
 */
public class Test {
    public static void main(String[] args) {
        EntryQueue entryControl = new EntryQueue();

        for (int index = 0; index < 5; index++) {
            Entry entry = Entry.createEntry("我是第" + index);
            entryControl.enqueue(entry);
        }
        System.out.println("存值完成===========================");
        while (true) {
            Entry pendingPost = entryControl.poll();
            if (pendingPost == null) {
                return;
            }
//            System.out.println().e(TAG,"我获取的记过" + pendingPost.subscription + "," + pendingPost.event);
        }

    }
}
