package com.versuchdrei.overflowbag.utils;

import java.util.List;
import java.util.Optional;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.java.JavaPlugin;

public class MetadataUtils {

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    public static <T> Optional<T> getMetadata(final JavaPlugin plugin, final Metadatable entity, final String key, final Class<T> type) {
        final List<MetadataValue> metadata = entity.getMetadata(key);
        for (final MetadataValue value : metadata) {
            if (value.getOwningPlugin() == plugin && type.isInstance(value.value())) {
                return Optional.of((T) value.value());
            }
        }

        return Optional.empty();
    }
}
