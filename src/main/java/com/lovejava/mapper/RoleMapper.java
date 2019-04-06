package com.lovejava.mapper;

import com.lovejava.domain.Role;

import java.util.List;

/**
 * @author:tianyao
 * @date:2019-04-04 14:35
 */
public interface RoleMapper {
    /**
     * 延迟查询
     */
    List<Role> findRole();
}
