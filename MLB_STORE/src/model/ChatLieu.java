/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ChatLieu{
    private int id;
    private String ten;
    private String trangthai;

    
    public Object[] toDataRow() {
        return new Object[]{
            id, ten, trangthai
        };
    }
    public ChatLieu() {
    }

    public ChatLieu(String ten) {
        this.ten = ten;
    }
    
    public ChatLieu(int id, String ten, String trangthai) {
        this.id = id;
        this.ten = ten;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    
}
