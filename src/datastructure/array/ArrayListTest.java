package datastructure.array;

/**
 * datastructure.array
 *
 * @author rj-liang
 * @date 2020/6/30 17:22
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(20);

        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }

        arrayList.insert(10, 1000);
        arrayList.insert(11, null);

        for (int i = 0; i < arrayList.size(); i ++) {
            System.out.println("" + arrayList.get(i));
        }

        for (Integer num: arrayList) {
            System.out.println("" + num);

        }

    }
}
