package ru.artemfirstov.worklist.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.artemfirstov.worklist.BR;
import ru.artemfirstov.worklist.R;
import ru.artemfirstov.worklist.databinding.TaskItemBinding;
import ru.artemfirstov.worklist.interfaces.OnItemClickInterface;
import ru.artemfirstov.worklist.model.Task;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    protected List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    class TaskViewHolder extends RecyclerView.ViewHolder implements OnItemClickInterface {
        private TaskItemBinding taskItemBinding;

        public TaskViewHolder(TaskItemBinding taskItem) {
            super(taskItem.getRoot());
            this.taskItemBinding = taskItem;
        }

        public void bind(Task task) {
            taskItemBinding.setVariable(BR.task, task);
            taskItemBinding.setClick(this);
            taskItemBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(Task task, int position) {
            task.status = true;
            taskList.set(position, task);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        TaskItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.task_item, viewGroup, false);
        return new TaskViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder taskViewHolder, int i) {
        taskViewHolder.bind(taskList.get(i));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
