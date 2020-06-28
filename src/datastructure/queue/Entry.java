package datastructure.queue;

/**
 * 参考EventBus PendingPostQueue
 *
 * @author rj-liang
 * @date 2020/5/18 19:06
 */
public class Entry {
    private String flag;
    Entry next;

    public Entry(String flag) {
        this.flag = flag;
    }

    public static Entry createEntry(String flag) {
        return new Entry(flag);
    }
}
