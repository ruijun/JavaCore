package object.transienttest;

import java.io.Serializable;

/**
 * object.transienttest
 *
 * @author rj-liang
 * @date 2021/3/1 11:19
 */
public class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;

    private String userName;
    private transient String passWd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

}
