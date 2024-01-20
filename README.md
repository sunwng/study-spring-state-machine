# Spring State Machine
References
- https://docs.spring.io/spring-statemachine/docs/4.0.0/reference/index.html
- https://www.baeldung.com/spring-state-machine

## Configuration
- Need to override configure functions of [EnumStateMachineConfigurerAdapter](https://github.com/spring-projects/spring-statemachine/blob/main/spring-statemachine-core/src/main/java/org/springframework/statemachine/config/AbstractStateMachineConfigurerAdapter.java)
- `public void configure(StateMachineStateConfigurer<States, Events> states)` &rarr; define states to use
- `public void configure(StateMachineTransitionConfigurer<States, Events> transitions)` &rarr; define transitions from a state to another