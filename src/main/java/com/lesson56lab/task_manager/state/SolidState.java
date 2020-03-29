package com.lesson56lab.task_manager.state;

public class SolidState implements State {

    private static final String NAME = "New";

    public String getName() {
        return NAME;
    }

    public void heat(StateContext context) {
        context.setState(new LiquidState());
    }

}
