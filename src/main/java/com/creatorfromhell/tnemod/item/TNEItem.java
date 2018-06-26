package com.creatorfromhell.tnemod.item;

import com.creatorfromhell.tnemod.TheNewEconomyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Daniel.
 *
 * The New Economy Client Mod
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0
 * International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
public class TNEItem extends Item {

  protected String unlocalizedName;

  public TNEItem(String name) {
    this.unlocalizedName = name;
    setUnlocalizedName(name);
    setRegistryName(name);
  }

  public void registerItemModel() {
    TheNewEconomyMod.proxy.registerItemRenderer(this, 0, unlocalizedName);
  }

  @Override
  public TNEItem setCreativeTab(CreativeTabs tab) {
    super.setCreativeTab(tab);
    return this;
  }
}