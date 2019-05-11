package ru.artemfirstov.worklist.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.artemfirstov.worklist.BR;
import ru.artemfirstov.worklist.R;
import ru.artemfirstov.worklist.databinding.TaskItemBinding;
import ru.artemfirstov.worklist.interfaces.OnItemClickInterface;
import ru.artemfirstov.worklist.model.Task;

// Адаптер для Task сущности
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    protected List<Task> taskList; //лист Taskов, которые отображаются во Recycle View

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }
    // Отвечает за отображение самой карточки
    class TaskViewHolder extends RecyclerView.ViewHolder implements OnItemClickInterface {
        private TaskItemBinding taskItemBinding;

        public TaskViewHolder(TaskItemBinding taskItem) {
            super(taskItem.getRoot()); //Сначала вызваем конструктор родительского класса, передаем View одного эл-та из списка
            Log.d("TaskApp", "New ViewHolder created");
            this.taskItemBinding = taskItem;
        }
    // метод bind привязывает конкретную модель к существующему классу binding
        public void bind(Task task) {
            taskItemBinding.setVariable(BR.task, task);
            taskItemBinding.setClick(this);
            taskItemBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(Task task, int position) { //метод изменяет выполненность дела
            task.status = true;
            taskList.set(position, task);
            notifyDataSetChanged(); //говорим адаптеру, что данные надо обновить, они изменились
        }
    }
    //Возвращает класс ViewHolder, в нем определяется LayoutInflater
    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        TaskItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.task_item, viewGroup, false); //Привязываем binding класс к конкретному View
        return new TaskViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder taskViewHolder, int i) { //заполняем карточку контентом
        taskViewHolder.bind(taskList.get(i));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
