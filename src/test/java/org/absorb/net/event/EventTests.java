package org.absorb.net.event;

import org.absorb.AbsorbManagers;
import org.absorb.event.Event;
import org.absorb.event.EventManager;
import org.absorb.event.annotations.OnEvent;
import org.absorb.event.cause.EventCause;
import org.absorb.event.combine.AwaitingEvent;
import org.absorb.event.combine.EventCombine;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.Collections;

public class EventTests {

    private EventManager manager;
    private EventCause willCause = new EventCause(Collections.emptyList());
    private EventCause hasCaused = new EventCause(Collections.emptyList());
    private String data;

    private MockedStatic<AbsorbManagers> staticManagers;

    public static final String TEST_FIRED = "test fired";

    public static class TestEvent implements AwaitingEvent {

        private final EventCause willCause;
        private final EventCause hasCaused;
        private final String randomData;

        public TestEvent(EventCause willCause, EventCause hasCaused, String randomData) {
            this.hasCaused = hasCaused;
            this.willCause = willCause;
            this.randomData = randomData;
        }

        public String getData() {
            return this.randomData;
        }

        @Override
        public @NotNull EventCause willCause() {
            return this.willCause;
        }

        @Override
        public @NotNull EventCause hasCaused() {
            return this.hasCaused;
        }

        @Override
        public Event copy() {
            return new TestEvent(this.willCause, this.hasCaused, this.randomData);
        }

        @Override
        public EventCombine<?> getCombiner() {
            return new EventCombine<TestEvent>() {
                @Override
                public void apply(TestEvent event) {

                }

                @Override
                public TestEvent build() {
                    return TestEvent.this;
                }
            };
        }
    }

    public class TestEventFired {

        @OnEvent
        public void testEventFired(TestEvent event) {
            EventTests.this.data = event.getData();
        }
    }

    @BeforeEach
    public void init() {
        this.manager = new EventManager();
        this.data = null;
        this.staticManagers = Mockito.mockStatic(AbsorbManagers.class);
        this.staticManagers.when(AbsorbManagers::getEventManager).thenReturn(this.manager);
    }

    @AfterEach
    public void post() {
        this.staticManagers.close();
        this.staticManagers = null;
    }

    @Test
    public void testEventHandlerSynced() {
        this.manager.registerAll(new TestEventFired());

        TestEvent event = new TestEvent(this.willCause, this.hasCaused, TEST_FIRED);
        TestEvent result = this.manager.callSynced(event);

        Assertions.assertEquals(event, result);
        Assertions.assertEquals(TEST_FIRED, this.data);
    }

    @Test
    public void testEventHandlerAwaited() {
        this.manager.registerAll(new TestEventFired());

        TestEvent event = new TestEvent(this.willCause, this.hasCaused, TEST_FIRED);
        TestEvent result = this.manager.callAwaiting(event);

        Assertions.assertEquals(event, result);
        Assertions.assertEquals(TEST_FIRED, this.data);
    }

    @Test
    public void testEventHandlerAsynced() {
        this.manager.registerAll(new TestEventFired());

        Event event = new TestEvent(this.willCause, this.hasCaused, TEST_FIRED);
        this.manager.callAsynced(event);


        LocalTime time = LocalTime.now();
        while (this.data==null) {
            if ((LocalTime.now().getSecond() - time.getSecond()) > 1) {
                Assertions.fail("Change never applied -> timed out");
                return;
            }
        }
        Assertions.assertEquals(TEST_FIRED, this.data);
    }
}
