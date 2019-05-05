package ru.artemfirstov.worklist.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import ru.artemfirstov.worklist.MainActivity;
import ru.artemfirstov.worklist.MyApplication;
import ru.artemfirstov.worklist.model.Task;

public class TaskActivityViewModel extends BaseObservable {
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> importance = new ObservableField<>();
    public final ObservableField<String> date = new ObservableField<>();

    private Context context;

    public TaskActivityViewModel(Context context) {
        this.context = context;
    }


    public void createTaskClick() {
        try {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Task completeTask = new Task(title.get(), false, description.get(), df.parse(date.get()), importance.get());
            MyApplication.taskList.add(completeTask);
            context.startActivity(new Intent(context, MainActivity.class));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
