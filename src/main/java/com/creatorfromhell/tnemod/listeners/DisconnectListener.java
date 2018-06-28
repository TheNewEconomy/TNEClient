package com.creatorfromhell.tnemod.listeners;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

@Mod.EventBusSubscriber
public class DisconnectListener {


  @SubscribeEvent(priority = EventPriority.HIGHEST)
  public void onDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
    Minecraft.getMinecraft().addScheduledTask(()->{
      MinecraftForge.EVENT_BUS.register(new EntityJoinWorldListener());
    });
  }
}