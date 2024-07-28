package de.dmt.swordsplus;

import de.dmt.swordsplus.system.ItemSystem;
import de.dmt.swordsplus.system.SystemBase;
import de.dmt.swordsplus.util.StringUtil;
import net.fabricmc.api.ModInitializer;

import java.util.List;

public class Swordsplus implements ModInitializer {
    public static final String MOD_ID = "swordsplus";
    public static final List<SystemBase> systems = List.of(
            new ItemSystem()
    );

    @Override
    public void onInitialize() {
        for (SystemBase systemBase : systems) {
            try {
                systemBase.initialize();
            } catch (Exception exception) {
                Log.errorf("Error while initializing system \"%s\":\n%s", systemBase.name, StringUtil.fromException(exception));
                throw new RuntimeException(exception);
            }
        }
    }
}
