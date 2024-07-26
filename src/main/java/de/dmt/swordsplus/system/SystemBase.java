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
            Log.warning("Tried to initialize system \"" + name + "\" multiple times. Ignoring...");
            return;
        }

        Log.info("Initializing system \"" + name + "\"");
        doInitialize();
        this.initialized = true;
    }

    protected abstract void doInitialize() throws Exception;
}
