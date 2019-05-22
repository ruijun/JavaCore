package annotation.apt;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date ${DATA} 下午4:56
 */
public class Student {
    @Name("AAA")
    private String stuName;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
