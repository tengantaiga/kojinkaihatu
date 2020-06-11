package jp.co.example.form;

import javax.validation.constraints.NotBlank;

/*
 * 登録画面用フォーム
 */
public class InsertForm {

    @NotBlank
    private String loginId;

    @NotBlank
    private String userName;


    @NotBlank
    private String password;

    private String confirmPassword;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String _loginId) {
        this.loginId = _loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String _userName) {
        this.userName = _userName;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String _confirmPassword) {
        this.confirmPassword = _confirmPassword;
    }
}
