package com.creatorfromhell.tnemod.registry;

import com.creatorfromhell.tnemod.item.TNEItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by Daniel.
 *
 * The New Economy Client Mod
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0
 * International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
public class ItemsRegistry {

  public static final TNEItem majorCurrency = new TNEItem("major_currency").setCreativeTab(CreativeTabs.MISC);
  public static final TNEItem minorCurrency = new TNEItem("minor_currency").setCreativeTab(CreativeTabs.MISC);

  public static void register(IForgeRegistry<Item> registry) {
    registry.registerAll(
        majorCurrency,
        minorCurrency
    );
  }

  public static void registerModels() {
    majorCurrency.registerItemModel();
    minorCurrency.registerItemModel();
  }
}