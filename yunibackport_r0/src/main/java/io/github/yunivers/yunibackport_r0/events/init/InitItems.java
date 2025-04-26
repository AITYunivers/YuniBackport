package io.github.yunivers.yunibackport_r0.events.init;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_r0.item.NetherWartSeeds;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.template.item.TemplateSeedsItem;

import static io.github.yunivers.yunibackport_r0.events.init.InitListener.NAMESPACE;

public class InitItems
{
    @EventListener
    public void initItems(ItemRegistryEvent event)
    {
        YuniBackport_r0.ITEM_BLAZE_ROD = new TemplateItem(NAMESPACE.id("blaze_rod"))
                .setTranslationKey(NAMESPACE.id("blaze_rod"));
        YuniBackport_r0.ITEM_BLAZE_POWDER = new TemplateItem(NAMESPACE.id("blaze_powder"))
                .setTranslationKey(NAMESPACE.id("blaze_powder"));
        YuniBackport_r0.ITEM_NETHER_WART = new NetherWartSeeds(NAMESPACE.id("nether_wart"))
                .setTranslationKey(NAMESPACE.id("nether_wart"));
    }
}
