package com.versuchdrei.overflowbag.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OverflowData {
    final private Map<Material, List<ItemStack>> itemStackMap;

    OverflowData(final List<ItemStack> itemStacks) {
        this.itemStackMap = new HashMap<Material, List<ItemStack>>();
        addItems(itemStacks);
    }

    public void addItems(final List<ItemStack> itemsToAdd) {
        for (final ItemStack itemStackToAdd : itemsToAdd) {
            final Material material = itemStackToAdd.getType();
            final List<ItemStack> itemStacks = itemStackMap.computeIfAbsent(material, (material1 -> new ArrayList<ItemStack>()));
            final List<ItemStack> notFullItemStacks = itemStacks
                    .stream()
                    .filter((itemStack -> itemStack.getMaxStackSize() == itemStack.getAmount()))
                    .collect(Collectors.toList());
            if (notFullItemStacks.size() == 0) {

            }

            for (final ItemStack notFullItemStack : notFullItemStacks) {

            }
        }
    }
}
