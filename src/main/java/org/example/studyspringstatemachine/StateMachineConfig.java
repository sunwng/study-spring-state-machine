package org.example.studyspringstatemachine;

import java.util.EnumSet;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states
            .withStates()
            .initial(States.BEFORE_EXECUTION)
            .end(States.AFTER_EXECUTION)
            .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
        throws Exception {
        transitions
            .withExternal()
                .source(States.BEFORE_EXECUTION).target(States.UNDER_EXECUTION).event(Events.START_EXECUTION)
                .and()
            .withExternal()
            .source(States.UNDER_EXECUTION).target(States.AFTER_EXECUTION).event(Events.END_EXECUTION);
    }
}
