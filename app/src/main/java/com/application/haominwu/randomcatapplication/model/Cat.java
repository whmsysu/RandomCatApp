package com.application.haominwu.randomcatapplication.model;

import com.google.gson.annotations.SerializedName;

public class Cat {

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @SerializedName("file")
    private String file;
}
