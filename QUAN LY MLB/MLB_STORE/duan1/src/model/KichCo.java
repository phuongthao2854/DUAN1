/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class KichCo {
    private int id;
    private String ten;
    private String trangThai;
    
    public Object[] toDataRow() {
        return new Object[]{
            id, ten, trangThai
        };
    }
    public KichCo() {
    }

    public KichCo(String ten) {
        this.ten = ten;
    }
    
    public KichCo(int id, String ten, String trangThai) {
        this.id = id;
        this.ten = ten;
        this.trangThai = trangThai;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
}
