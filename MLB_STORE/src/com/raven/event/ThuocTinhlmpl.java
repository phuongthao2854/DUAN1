/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.event;

import java.util.List;
import model.ChatLieu;
import model.DanhMuc;
import model.KichCo;
import model.MauSac;

/**
 *
 * @author Admin
 */
public interface ThuocTinhlmpl {
    List<MauSac> getAllMs();
    List<ChatLieu> getAllCl();
    List<KichCo> getAllKc();
    List<DanhMuc> getAllDM();
    void addMauSac(MauSac ms);
    void addChatLieu(ChatLieu cl);
    void addKichCo(KichCo kc);
    void addDanhMuc(DanhMuc dm);
}
