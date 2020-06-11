package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Role;

/*
 * roleテーブル用DAO (インターフェース)
 */
public interface RoleDao {

    public List<Role> findAll();
}
