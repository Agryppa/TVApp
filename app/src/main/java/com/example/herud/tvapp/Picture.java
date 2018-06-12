package com.example.herud.tvapp;

/**
 * Created by Herud on 2018-06-11.
 */

public class Picture {

    private Integer id;
    private String name;
    public Picture(int id,String name)
    {
        this.id=id;
        this.name=name;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
