package com.sys.dao;

import com.sys.entity.ResourcesDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhongqian
 * @since 2019-11-08
 */
public interface ResourcesMapper extends BaseMapper<ResourcesDO> {
    /**
     * 分页查询
     *
     * @param map
     * @return
     */
    List<ResourcesDO> findPageBreakByCondition(Map<String,Object> map);

    List<ResourcesDO> listUserResources(Map<String, Object> map);

    /**
     * 该节代码参考自http://blog.csdn.net/poorcoder_/article/details/71374002
     * 感谢网友
     *
     * @param rid
     * @return
     */
    List<ResourcesDO> queryResourcesListWithSelected(Long rid);

    List<ResourcesDO> listUrlAndPermission();

    List<ResourcesDO> listAllAvailableMenu();

    List<ResourcesDO> listMenuResourceByPid(Long pid);

    List<ResourcesDO> listByUserId(Long userId);
}
