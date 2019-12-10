package com.gousade.pojo;

import java.util.Date;

public class Trole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trole.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trole.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trole.remarks
     *
     * @mbggenerated
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trole.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trole.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trole.delflag
     *
     * @mbggenerated
     */
    private String delflag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trole.id
     *
     * @return the value of trole.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trole.id
     *
     * @param id the value for trole.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trole.name
     *
     * @return the value of trole.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trole.name
     *
     * @param name the value for trole.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trole.remarks
     *
     * @return the value of trole.remarks
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trole.remarks
     *
     * @param remarks the value for trole.remarks
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trole.create_time
     *
     * @return the value of trole.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trole.create_time
     *
     * @param createTime the value for trole.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trole.update_time
     *
     * @return the value of trole.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trole.update_time
     *
     * @param updateTime the value for trole.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trole.delflag
     *
     * @return the value of trole.delflag
     *
     * @mbggenerated
     */
    public String getDelflag() {
        return delflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trole.delflag
     *
     * @param delflag the value for trole.delflag
     *
     * @mbggenerated
     */
    public void setDelflag(String delflag) {
        this.delflag = delflag == null ? null : delflag.trim();
    }
}