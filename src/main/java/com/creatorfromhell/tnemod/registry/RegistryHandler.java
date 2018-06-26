package com.creatorfromhell.tnemod.registry;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Daniel.
 *
 * The New Economy Client Mod
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0
 * International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
@Mod.EventBusSubscriber
public class RegistryHandler {

  @SubscribeEvent
  public static void registerItems(RegistryEvent.Register<Item> event) {
    ItemsRegistry.register(event.getRegistry());
  }
}