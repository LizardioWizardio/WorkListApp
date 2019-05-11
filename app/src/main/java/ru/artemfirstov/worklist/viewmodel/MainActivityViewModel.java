package ru.artemfirstov.worklist.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;

import ru.artemfirstov.worklist.CreateTaskActivity;
import ru.artemfirstov.worklist.MyApplication;
import ru.artemfirstov.worklist.adapter.TaskAdapter;
// VM для MainActivity, MainActivity - View в концепции MVVM
// VM отвечает за обработку любых действий пользователя
//Передаем контекст
public class MainActivityViewModel extends BaseObservable {
    private TaskAdapter taskAdapter;

    private Context context;

    public MainActivityViewModel(Context context) {
        this.context = context;
    }

    public void onCreate() {
        taskAdapter = new TaskAdapter(MyApplication.taskList);
    }

    //Нужно для View, привязан к XML content_main
    //Он адаптирует данные для Recycler View
    public TaskAdapter getTaskAdapter() {
        return taskAdapter;
    }

    // Обработка нажатия на FAB
    public void onClickCreate() {
        Intent intent = new Intent(context, CreateTaskActivity.class);
        context.startActivity(intent);
    }
}