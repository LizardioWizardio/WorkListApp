package ru.artemfirstov.worklist;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import ru.artemfirstov.worklist.model.Task;

public class MyApplication extends Application {
    public static List<Task> taskList = new ArrayList<>();
}
