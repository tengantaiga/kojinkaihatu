package jp.co.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.RoleDao;
import jp.co.example.entity.Role;
import jp.co.example.service.RoleService;

/*
 * roleテーブル用サービス実装クラス
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 全件取得
     */
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
