package ru.artemfirstov.worklist.interfaces;

import ru.artemfirstov.worklist.model.Task;

public interface OnItemClickInterface {
    void onItemClick(Task task, int position);
}
