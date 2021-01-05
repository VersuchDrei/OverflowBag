package com.versuchdrei.overflowbag;

import com.versuchdrei.menumanager.implementations.events.InventoryOverflowEvent;
import com.versuchdrei.overflowbag.utils.MetadataUtils;
import com.versuchdrei.overflowbag.utils.OverflowData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.List;
import java.util.Optional;

public class EventListener implements Listener {
    private static final String METADATA_KEY_OVERFLOW_BAG = "overflowBag";
    private final Main plugin;

    public EventListener(final Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryOverloard(final InventoryOverflowEvent event) {
        final Player player = event.getPlayer();
        final List<ItemStack> itemStacks = event.getItems();
        final Optional<OverflowData> savedItemStacks = MetadataUtils.getMetadata(plugin, player, EventListener.METADATA_KEY_OVERFLOW_BAG, OverflowData.class);
        player.setMetadata(EventListener.METADATA_KEY_OVERFLOW_BAG, new FixedMetadataValue(plugin, items));
    }
}
