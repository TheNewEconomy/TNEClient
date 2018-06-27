package com.creatorfromhell.tnemod.item;

import com.creatorfromhell.tnemod.TheNewEconomyMod;
import com.creatorfromhell.tnemod.registry.ItemsRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Created by Daniel.
 *
 * The New Economy Client Mod
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0
 * International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
public class TNETab extends CreativeTabs {

  public TNETab() {
    super(TheNewEconomyMod.MODID);
  }

  @Override
  public ItemStack getTabIconItem() {
    return new ItemStack(ItemsRegistry.majorCurrency);
  }
}