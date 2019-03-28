package com.atguigu.atcrowdfunding.util;


import java.util.List;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈分页工具类〉
 *
 * @author chen
 * @create 2019/3/12
 */
public class Page {
    /**
     * 第几页
     */
    private Integer pageno;
    /**
     * 每页显示条数
     */
    private Integer pagesize;
    /**
     * 总共多少页
     */
    private Integer totalno;
    /**

     * 总共多少记录
     */
    private Integer totalsize;
    /**
     * 每页存放的数据
     */
    private List datas;

    public Page(Integer pageno,Integer pagesize){
        if(pageno <= 0){
            this.pageno = 1;
        }else {
            this.pageno = pageno;
        }
        if(pagesize <= 0){
            this.pagesize = 10;
        }else {
            this.pagesize = pagesize;
        }

    }
    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getTotalno() {
        return totalno;
    }

    private void setTotalno(Integer totalno) {
        this.totalno = totalno;
    }

    public Integer getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(Integer totalsize) {
        this.totalsize = totalsize;
        this.totalno = totalsize%pagesize==0?(totalsize/pagesize):(totalsize/pagesize+1);
    }

    public List getDatas() {
        return datas;
    }

    public void setDatas(List list) {
        this.datas = list;
    }

    /**
     * 获取开始索引
     * @return
     */
    public Integer getStartIndex(){
        return (pageno-1)*pagesize;
    }

}
