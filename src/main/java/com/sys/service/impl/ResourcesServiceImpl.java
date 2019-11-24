package com.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sys.comm.page.TableSupport;
import com.sys.entity.ResourcesDO;
import com.sys.dao.ResourcesMapper;
import com.sys.service.ResourcesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.web.controller.vo.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhongqian
 * @since 2019-11-08
 */
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, ResourcesDO> implements ResourcesService {

    @Autowired
    private ResourcesMapper resourceMapper;

    /**
     * 分页查询
     *
     * @param map query keywords
     * @return
     */
    @Override
    public PageInfo<Resources> findPageBreakByCondition(Map<String,Object> map) {
        TableSupport.startPage();
        List<ResourcesDO> sysResources = resourceMapper.findPageBreakByCondition(map);
        if (CollectionUtils.isEmpty(sysResources)) {
            return null;
        }
        List<Resources> resources = new ArrayList<>();
        for (ResourcesDO r : sysResources) {
            resources.add(new Resources(r));
        }
        PageInfo bean = new PageInfo<ResourcesDO>(sysResources);
        bean.setList(resources);
        return bean;
    }

    /**
     * 获取用户的资源列表
     *
     * @param map
     * @return
     */
    @Override
    public List<Resources> listUserResources(Map<String, Object> map) {
        List<ResourcesDO> sysResources = resourceMapper.listUserResources(map);
        if (CollectionUtils.isEmpty(sysResources)) {
            return null;
        }
        List<Resources> resources = new ArrayList<>();
        for (ResourcesDO r : sysResources) {
            resources.add(new Resources(r));
        }
        return resources;
    }

    /**
     * 获取ztree使用的资源列表
     *
     * @param rid
     * @return
     */
    @Override
    public List<Map<String, Object>> queryResourcesListWithSelected(Long rid) {
        List<ResourcesDO> sysResources = resourceMapper.queryResourcesListWithSelected(rid);
        if (CollectionUtils.isEmpty(sysResources)) {
            return null;
        }
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (ResourcesDO resources : sysResources) {
            map = new HashMap<String, Object>(3);
            map.put("id", resources.getId());
            map.put("pId", resources.getParentId());
            map.put("checked", resources.getChecked());
            map.put("name", resources.getName());
            mapList.add(map);
        }
        return mapList;
    }

    /**
     * 获取资源的url和permission
     *
     * @return
     */
    @Override
    public List<Resources> listUrlAndPermission() {
        List<ResourcesDO> sysResources = resourceMapper.listUrlAndPermission();
        return getResources(sysResources);
    }

    /**
     * 获取所有可用的菜单资源
     *
     * @return
     */
    @Override
    public List<Resources> listAllAvailableMenu() {
        List<ResourcesDO> sysResources = resourceMapper.listAllAvailableMenu();
        return getResources(sysResources);
    }

    /**
     * 获取父级资源下所有menu资源
     *
     * @param pid
     * @return
     */
    @Override
    public List<Map<String, Object>> listChildMenuByPid(Long pid) {
        List<ResourcesDO> sysResources = resourceMapper.listMenuResourceByPid(pid);
        if(CollectionUtils.isEmpty(sysResources)){
            return null;
        }
        List<Map<String, Object>> result = new LinkedList<>();
        Map<String, Object> item = null;
        for (ResourcesDO sysResource : sysResources) {
            item = new HashMap<>(2);
            item.put("value", sysResource.getId());
            item.put("text", sysResource.getName());
            result.add(item);
        }
        return result;
    }

    /**
     * 获取用户关联的所有资源
     *
     * @param userId
     * @return
     */
    @Override
    public List<Resources> listByUserId(Long userId) {
        List<ResourcesDO> sysResources = resourceMapper.listByUserId(userId);
        return getResources(sysResources);
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity
     * @return
     */
    @Override
    public Resources insert(Resources entity) {
        Assert.notNull(entity, "Resources不可为空！");
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        resourceMapper.insert(entity.getSysResources());
        return entity;
    }

    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含id属性并且必须为自增列
     *
     * @param entities
     */
    @Override
    public void insertList(List<Resources> entities) {
        Assert.notNull(entities, "entities不可为空！");
        List<ResourcesDO> sysResources = new ArrayList<>();
        for (Resources resources : entities) {
            resources.setUpdateTime(LocalDateTime.now());
            resources.setCreateTime(LocalDateTime.now());
            sysResources.add(resources.getSysResources());
        }
        this.saveBatch(sysResources);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param primaryKey
     * @return
     */
    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
      return   resourceMapper.deleteById(primaryKey) > 0;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param entity
     * @return
     */
    @Override
    public boolean update(Resources entity) {
        Assert.notNull(entity, "Resources不可为空！");
        entity.setUpdateTime(LocalDateTime.now());
        return resourceMapper.updateById(entity.getSysResources()) > 0;
    }

    /**
     * 根据主键更新属性不为null的值
     *
     * @param entity
     * @return
     */
    @Override
    public boolean updateSelective(Resources entity) {
        Assert.notNull(entity, "Resources不可为空！");
        entity.setUpdateTime(new Date());
        return resourceMapper.updateByPrimaryKeySelective(entity.getSysResources()) > 0;
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param primaryKey
     * @return
     */
    @Override
    public Resources getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        SysResources sysResources = resourceMapper.selectByPrimaryKey(primaryKey);
        return null == sysResources ? null : new Resources(sysResources);
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果时抛出异常，查询条件使用等号
     *
     * @param entity
     * @return
     */
    @Override
    public Resources getOneByEntity(Resources entity) {
        Assert.notNull(entity, "User不可为空！");
        SysResources sysResources = resourceMapper.selectOne(entity.getSysResources());
        return null == sysResources ? null : new Resources(sysResources);
    }

    /**
     * 查询全部结果，listByEntity(null)方法能达到同样的效果
     *
     * @return
     */
    @Override
    public List<Resources> listAll() {
        List<ResourcesDO> sysResources = resourceMapper.selectAll();
        return getResources(sysResources);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param entity
     * @return
     */
    @Override
    public List<Resources> listByEntity(Resources entity) {
        Assert.notNull(entity, "Resources不可为空！");
        List<ResourcesDO> sysResources = resourceMapper.select(entity.getSysResources());
        return getResources(sysResources);
    }

    private List<Resources> getResources(List<ResourcesDO> sysResources) {
        if (CollectionUtils.isEmpty(sysResources)) {
            return null;
        }
        List<Resources> resources = new ArrayList<>();
        for (ResourcesDO r : sysResources) {
            resources.add(new Resources(r));
        }
        return resources;
    }
}
