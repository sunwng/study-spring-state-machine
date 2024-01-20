package org.example.studyspringstatemachine;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class EventController{
    @Autowired
    private StateMachine<States, Events> stateMachine;

    @PostMapping("/publish-event/{event}")
    public void publishEvent(
        @PathVariable Events event
    ) {
        stateMachine.start();
        System.out.println(stateMachine.getState());
        stateMachine.sendEvent(event);
        System.out.println(stateMachine.getState());
    }
}
