package ru.artemfirstov.worklist;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import ru.artemfirstov.worklist.model.Task;
// наследуемся от Application и получаем хранилище данных с глобальным доступом, этот класс создается в начале приложения
// экземпляр этого класса не уничтожается на протяжении всей работы приложения
public class MyApplication extends Application {
    public static List<Task> taskList = new ArrayList<>();
}
