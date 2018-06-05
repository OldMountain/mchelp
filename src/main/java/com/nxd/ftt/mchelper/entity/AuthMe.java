package com.nxd.ftt.mchelper.entity;
import com.google.gson.Gson;


/**
 * AuthMe
 *
 * @author luhangqi
 * @date 2018/06/04
 */
public class AuthMe {

    private Integer id;

    private String username;

    private String realname;

    private String password;

    private String ip;

    private long lastlogin;

    private double x;

    private double y;

    private double z;

    private String world;

    private String email;

    private Integer islogged;

    private Integer hassession;

    private long regdate;

    private String regip;

    private float yaw;

    private float pitch;


    /** 
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /** 
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /** 
     *
     * @return realname
     */
    public String getRealname() {
        return realname;
    }

    /** 
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /** 
     *
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /** 
     *
     * @return lastlogin
     */
    public long getLastlogin() {
        return lastlogin;
    }

    /** 
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /** 
     *
     * @return y
     */
    public double getY() {
        return y;
    }

    /** 
     *
     * @return z
     */
    public double getZ() {
        return z;
    }

    /** 
     *
     * @return world
     */
    public String getWorld() {
        return world;
    }

    /** 
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /** 
     *
     * @return islogged
     */
    public Integer getIslogged() {
        return islogged;
    }

    /** 
     *
     * @return hassession
     */
    public Integer getHassession() {
        return hassession;
    }

    /** 
     *
     * @return regdate
     */
    public long getRegdate() {
        return regdate;
    }

    /** 
     *
     * @return regip
     */
    public String getRegip() {
        return regip;
    }

    /** 
     *
     * @return yaw
     */
    public float getYaw() {
        return yaw;
    }

    /** 
     *
     * @return pitch
     */
    public float getPitch() {
        return pitch;
    }


    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 
     */
    public void setLastlogin(long lastlogin) {
        this.lastlogin = lastlogin;
    }

    /**
     * 
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * 
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * 
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * 
     */
    public void setWorld(String world) {
        this.world = world;
    }

    /**
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     */
    public void setIslogged(Integer islogged) {
        this.islogged = islogged;
    }

    /**
     * 
     */
    public void setHassession(Integer hassession) {
        this.hassession = hassession;
    }

    /**
     * 
     */
    public void setRegdate(long regdate) {
        this.regdate = regdate;
    }

    /**
     * 
     */
    public void setRegip(String regip) {
        this.regip = regip;
    }

    /**
     * 
     */
    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    /**
     * 
     */
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}