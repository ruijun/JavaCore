package generic;

/**
 * Box
 *
 * @autor rj-liang
 * @date 17-5-16 下午2:06
 */
public class Box<T> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
