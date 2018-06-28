package com.creatorfromhell.tnemod.listeners;

import com.creatorfromhell.tnemod.TheNewEconomyMod;
import com.creatorfromhell.tnemod.network.TNEModCheckMessage;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EntityJoinWorldListener {

  @SubscribeEvent(priority = EventPriority.HIGHEST)
  public void onConnect(EntityJoinWorldEvent event) {
    Minecraft.getMinecraft().addScheduledTask(()->{
      TheNewEconomyMod.wrapper.sendToServer(new TNEModCheckMessage());
      MinecraftForge.EVENT_BUS.unregister(this);
    });
  }
}