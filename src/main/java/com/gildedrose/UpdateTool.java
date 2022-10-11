package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class UpdateTool {
    private static final Update DEFAULT_UPDATE = new DefaultUpdate();
    private static final Map<String, Update> SPECIFIC_UPDATE = new HashMap<String, Update>() {{
        put("Aged Brie", new AgedBrieUpdate());
        put("Backstage passes to a TAFKAL80ETC concert", new BackstageUpdate());
        put("Sulfuras, Hand of Ragnaros", new SulfurasUpdate());
        put("Conjured Mana Cake", new ConjuredUpdate());
    }};

    public static void updateQuality(Item item) {
        
    }
}
