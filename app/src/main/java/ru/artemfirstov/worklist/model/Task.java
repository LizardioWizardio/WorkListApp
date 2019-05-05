package ru.artemfirstov.worklist.model;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    public String title;
    public boolean status;
    public String description;
    public Date date;
    public String importance;

    public Task(String title, boolean status, String description, Date date, String importance) {
        this.title = title;
        this.status = status;
        this.description = description;
        this.date = date;
        this.importance = importance;
    }

    public String convertToString() {
        String stringFormat = null;
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            stringFormat = sdf.format(date);
        } catch (Exception ex) {
            Log.d("taskApp", ex.getMessage());
        }

        return stringFormat;
    }
}
