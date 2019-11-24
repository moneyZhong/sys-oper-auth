package com.sys.service;

import com.github.pagehelper.PageInfo;
import com.sys.entity.ResourcesDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.web.controller.vo.Resources;

import java.util.List;
import java.util.Map;

/**
 * <p>
    *  服务类
    * </p>
 *
 * @author zhongqian
 * @since 2019-11-08
 */
public interface ResourcesService extends IService<ResourcesDO> {

    /**
     * 分页查询
     *
     * @param map
     * @return
     */
    PageInfo<Resources> findPageBreakByCondition(Map<String,Object> map);

    /**
     * 获取用户的资源列表
     *
     * @param map
     * @return
     */
    List<Resources> listUserResources(Map<String, Object> map);

    /**
     * 获取ztree使用的资源列表
     *
     * @param rid
     * @return
     */
    List<Map<String, Object>> queryResourcesListWithSelected(Long rid);

    /**
     * 获取资源的url和permission
     *
     * @return
     */
    List<Resources> listUrlAndPermission();

    public Resources insert(Resources entity);

    public void insertList(List<Resources> entities);

    public boolean removeByPrimaryKey(Long primaryKey);


    /**
     * 获取所有可用的菜单资源
     *
     * @return
     */
    List<Resources> listAllAvailableMenu();

    /**
     * 获取父级资源下所有menu资源
     *
     * @return
     */
    List<Map<String, Object>> listChildMenuByPid(Long pid);

    /**
     * 获取用户关联的所有资源
     *
     * @param userId
     * @return
     */
    List<Resources> listByUserId(Long userId);


}
