package ru.artemfirstov.worklist.interfaces;

import ru.artemfirstov.worklist.model.Task;
//интерфейс для xml
public interface OnItemClickInterface {
    void onItemClick(Task task, int position);
}
