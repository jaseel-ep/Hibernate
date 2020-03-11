package org.hibernate.DTO;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Login implements Serializable {
    private String loginID;
    private String loginPassword;

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginID='" + loginID + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }
}
