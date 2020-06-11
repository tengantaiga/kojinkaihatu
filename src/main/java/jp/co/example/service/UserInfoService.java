package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.UserInfo;

/*
 * user_infoテーブル用サービスインターフェース
 */
public interface UserInfoService {
    public UserInfo authentication(String loginId, String pass);

    public List<UserInfo> find(UserInfo userInfo);

    public UserInfo findByLoginId(String loginId);

    public boolean existsUserByLoginId(String loginId);

    public void insert(UserInfo userInfo);
}
