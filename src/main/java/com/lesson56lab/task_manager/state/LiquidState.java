package com.lesson56lab.task_manager.state;


public class LiquidState implements State {

    private static final String NAME = "In Work";

    public String getName() {
        return NAME;
    }

    public void heat(StateContext context) {
        context.setState(new GaseousState());
    }

}
