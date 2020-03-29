package com.lesson56lab.task_manager.state;

public interface State {
    String getName();
    void heat(StateContext context);
}
