package org.absorb.environment;

import org.absorb.environment.change.EnvironmentChange;

import java.util.concurrent.PriorityBlockingQueue;

public interface ChangeEnvironment extends Environment {

    PriorityBlockingQueue<EnvironmentChange> getChanges();
}
