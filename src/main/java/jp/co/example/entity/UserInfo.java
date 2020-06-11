package jp.co.example.entity;

import jp.co.example.util.ParamUtil;

/**
 * user_infoテーブルのEntity
 */
public class UserInfo {
   // private static final Integer ADMIN_ROLE_ID = 1; // 管理者を表すrole_idの値

    private Integer userId; // user_id
    private String loginId; // login_id
    private String userName; // user_name
    private String password; // password


    public UserInfo() {

    }

    public UserInfo(Integer _userId,String _loginId, String _userName, String _password) {
    	userId = _userId;
        loginId = _loginId;
        userName = _userName;
        password = _password;
    }

//    public UserInfo(Integer _userId, String _loginId, String _userName, String _telephone, String _password,
//            Integer _roleId, String _roleName) {
//        this(_userId, _loginId, _userName, _telephone, _password, _roleId);
//        roleName = _roleName;
//    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer _userId) {
        userId = _userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String _userName) {
        userName = _userName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String _loginId) {
        loginId = _loginId;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        password = _password;
    }



    /**
     * 検索条件用の項目が全て未入力かを確認する
     * (全て未入力ならtrue)
     */
    public boolean isEmptyCondition() {
        return userId == null && ParamUtil.isNullOrEmpty(userName) ;
    }


    /**
     * equalsメソッドオーバーライド
     * 各フィールドの値(roleName以外)が全て同じ場合もtrueとする
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        UserInfo other = (UserInfo) obj;

        if (userId == null) {
            if (other.userId != null) {
                return false;
            }
        } else if (!userId.equals(other.userId)) {
            return false;
        }

        if (loginId == null) {
            if (other.loginId != null) {
                return false;
            }
        } else if (!loginId.equals(other.loginId)) {
            return false;
        }

        if (userName == null) {
            if (other.userName != null) {
                return false;
            }
        } else if (!userName.equals(other.userName)) {
            return false;
        }

        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }



        return true;
    }
}
