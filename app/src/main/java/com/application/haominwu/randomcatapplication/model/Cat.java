package com.application.haominwu.randomcatapplication.model;

import com.google.gson.annotations.SerializedName;

import org.litepal.LitePal;
import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Cat extends LitePalSupport {

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Column(unique = true)
    @SerializedName("file")
    private String file;

    /**
     *
     */
    private static void clearAllCats() {
        LitePal.deleteAll(Cat.class);
    }

    /**
     *
     * @param cat
     */
    public static void saveACat(Cat cat) {
        clearAllCats();
        cat.save();
    }

    /**
     *
     * @return
     */
    public static Cat getACat() {
        List<Cat> allCats = LitePal.findAll(Cat.class);
        if (allCats.isEmpty()) {
            return null;
        }
        else {
            return allCats.get(0);
        }
    }
}
