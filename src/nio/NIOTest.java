package nio;

import java.nio.IntBuffer;

/**
 * nio
 *
 * @author rj-liang
 * @date 2020/6/5 10:58
 */
public class NIOTest {
    /**
     * 容量(Capacity)：缓冲区能够容纳的数据元素的最大数量。这一容量在缓冲区创建时被设定，并且永远不能被改变。
     *
     * 上界(Limit)：缓冲区的第一个不能被读或写的元素。缓冲创建时，limit 的值等于 capacity 的值。假设 capacity = 1024，我们在程序中设置了 limit = 512，说明，Buffer 的容量为 1024，
     * 但是从 512 之后既不能读也不能写，因此可以理解成，Buffer 的实际可用大小为 512。
     *
     * 位置(Position)：下一个要被读或写的元素的索引。位置会自动由相应的 get() 和 put() 函数更新。 这里需要注意的是positon的位置是从0开始的。
     *
     * 标记(Mark)：一个备忘位置。标记在设定前是未定义的(undefined)。使用场景是，假设缓冲区中有 10 个元素，position 目前的位置为 2(也就是如果get的话是第三个元素)，
     * 6 - 10 之间的缓冲数据，此时我们可以 buffer.mark(buffer.position())，即把当前的 position 记入 mark 中，然后 buffer.postion(6)，
     * 此时发送给 channel 的数据就是 6 - 10 的数据。发送完后，我们可以调用 buffer.reset() 使得 position = mark，因此这里的 mark 只是用于临时记录一下位置用的。
     *
     */
    public static void main(String[] args) {
//        testFlip();
        testMark();
    }

    private static void testFlip() {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.print("1、写入数据之前的position、limit和capacity: ");
        System.out.println("position = " + intBuffer.position() + " ,limit = " + intBuffer.limit() + " ,capacity = " + intBuffer.capacity());
        int[] intArray = {1, 2, 3, 4, 5, 6};
        intBuffer.put(intArray);

        System.out.print("2、写入数据之后的position、limit和capacity: ");
        System.out.println("position = " + intBuffer.position() + " ,limit = " + intBuffer.limit() + " ,capacity = " + intBuffer.capacity());

        intBuffer.flip();
        System.out.print("3、准备输出数据时的position、limit和capacity: ");
        System.out.println("position = " + intBuffer.position() + " ,limit = " + intBuffer.limit() + " ,capacity = " + intBuffer.capacity());
        System.out.print("缓冲区中的内容：");

        while (intBuffer.hasRemaining()) {
            int x = intBuffer.get();
            System.out.print(x + "、");
        }

    }

    private static void testMark() {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.print("1、写入数据之前的position、limit和capacity: ");
        System.out.println("position = " + intBuffer.position() + " ,limit = " + intBuffer.limit() + " ,capacity = " + intBuffer.capacity());
        int[] intArray = {1, 2, 3, 4, 5, 6};
        intBuffer.put(intArray);

        System.out.print("2、写入数据之后的position、limit和capacity: ");
        System.out.println("position = " + intBuffer.position() + " ,limit = " + intBuffer.limit() + " ,capacity = " + intBuffer.capacity());

        intBuffer.mark();
        intBuffer.position(2);
        System.out.print("3、准备输出数据时的position、limit和capacity: ");
        System.out.println("position = " + intBuffer.position() + " ,limit = " + intBuffer.limit() + " ,capacity = " + intBuffer.capacity() + " ,mark = " + intBuffer.mark());
        System.out.print("缓冲区中的内容：");

        while (intBuffer.hasRemaining()) {
            int x = intBuffer.get();
            System.out.print(x + "、");
        }

        intBuffer.reset();
        System.out.print("4、准备输出数据时的position、limit和capacity: ");
        System.out.println("position = " + intBuffer.position() + " ,limit = " + intBuffer.limit() + " ,capacity = " + intBuffer.capacity() + " ,mark = " + intBuffer.mark());

//        while (intBuffer.hasRemaining()) {
//            int x = intBuffer.get();
//            System.out.print(x + "、");
//        }
    }

    private static void testAA() {
        IntBuffer buf = IntBuffer.allocate(10); // 准备出10个大小的缓冲区
        IntBuffer sub = null; // 定义子缓冲区
        for (int i = 0; i < 10; i++) {
            buf.put(2 * i + 1); // 在主缓冲区中加入10个奇数
        }

        // 需要通过slice() 创建子缓冲区
        buf.position(2);
        buf.limit(6);
        sub = buf.slice();
        for (int i = 0; i < sub.capacity(); i++) {
            int temp = sub.get(i);
            sub.put(temp - 1);
        }

        buf.flip(); // 重设缓冲区
        buf.limit(buf.capacity());
        System.out.print("主缓冲区中的内容：");
        while (buf.hasRemaining()) {
            int x = buf.get();
            System.out.print(x + "、");
        }
    }
}
