package ru.artemfirstov.worklist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ru.artemfirstov.worklist.databinding.ContentCreateTaskBinding;
import ru.artemfirstov.worklist.viewmodel.TaskActivityViewModel;

public class CreateTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        TaskActivityViewModel taskActivityViewModel = new TaskActivityViewModel(this);

        ContentCreateTaskBinding binding = DataBindingUtil.setContentView(this, R.layout.content_create_task);
        binding.setTaskModel(taskActivityViewModel);
    }

}
