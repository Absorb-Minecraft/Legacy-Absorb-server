package org.absorb.event.trigger;

public interface EventTriggerTypes {

    SyncedTriggerType SYNCED = new SyncedTriggerType();
    AwaitedTriggerType AWAITED = new AwaitedTriggerType();
    AsyncedTriggerType ASYNCED = new AsyncedTriggerType();
}
