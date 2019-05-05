package ru.artemfirstov.worklist.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;

import ru.artemfirstov.worklist.CreateTaskActivity;
import ru.artemfirstov.worklist.MyApplication;
import ru.artemfirstov.worklist.adapter.TaskAdapter;

public class MainActivityViewModel extends BaseObservable {
    private TaskAdapter taskAdapter;

    private Context context;

    public MainActivityViewModel(Context context) {
        this.context = context;
    }

    public void onCreate() {
        taskAdapter = new TaskAdapter(MyApplication.taskList);
    }

    public TaskAdapter getTaskAdapter() {
        return taskAdapter;
    }

    public void onClickCreate() {
        Intent intent = new Intent(context, CreateTaskActivity.class);
        context.startActivity(intent);
    }
}