package net.canway.demos.demo.service;

import net.canway.demos.demo.pojos.DepBean;

import java.util.List;

/**
 * 部门服务接口
 */
public interface DepService {

    /**
     * 获取当前所有部门
     */
    List<DepBean> list();

    /**
     * 通过ID获取部门信息
     * @param depId
     * @return
     */
    DepBean getDepById(Integer depId);

    /**
     * 更新部门信息
     * @param depBean
     * @return
     */
    boolean update(DepBean depBean);

    /**
     * 添加部门信息
     * @param depBean
     * @return
     */
    boolean add(DepBean depBean);

    /**
     * 通过部门ID删除部门
     * @param depId
     * @return
     */
    boolean delete(Integer depId);

}
