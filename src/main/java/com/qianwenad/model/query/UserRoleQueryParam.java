package com.qianwenad.model.query;

/**
 * Created with IntelliJ IDEA.
 * Author: andy.yang
 * Date: 2018/7/9
 * Time: 11:46
 * Description:
 */
public class UserRoleQueryParam {

    private Long userId;
    private Long roleId;

    //额外添加的请求入参参数
    private Integer page = 0;
    private Integer pageSize = 0;
    private String[] sort = {"id"};

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String[] getSort() {
        return sort;
    }

    public void setSort(String[] sort) {
        this.sort = sort;
    }
}
