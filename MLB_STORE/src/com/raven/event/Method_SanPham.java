/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.event;

import java.util.List;

/**
 *
 * @author anh
 */
public interface Method_SanPham<Entity> {

    List<Entity> selectbySQL(String Sql, Object... orgs);

    List<Entity> getALL();

    List<Entity> getALLresultPage();

    List<Entity> getbyEntityhidden();

    List<Entity> findEntity(String data);

    List<Entity> findEntityhidden(String data);

    Entity getbyID(int id);

    String addEntity(Entity ett);

    String deleteEntity(int id);

    String updateEntity(Entity ett, int id);

    void hiddenEntity(int id);

    void unhiddenEntity(int id);

    List<Entity> resultPage(int page, int limit);
}
