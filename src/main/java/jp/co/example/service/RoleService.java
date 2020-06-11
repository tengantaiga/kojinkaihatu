package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Role;

/*
 * roleテーブル用サービスインターフェース
 */
public interface RoleService {
    public List<Role> findAll();
}
