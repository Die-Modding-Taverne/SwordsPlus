package de.dmt.swordsplus.system;

import de.dmt.swordsplus.Log;
import it.unimi.dsi.fastutil.ints.IntIntImmutablePair;

public abstract class SystemBase {

    public final String name;

    private boolean initialized;

    public SystemBase(String name) {
        this.name = name;
        this.initialized = false;
    }

    public void initialize() throws Exception {
        if (initialized) {
            Log.warnf("Tried to initialize system \"%s\" multiple times. Ignoring...", name);
            return;
        }

        Log.infof("Initializing system \"%s\"", name);
        doInitialize();
        this.initialized = true;
    }

    protected abstract void doInitialize() throws Exception;
}
