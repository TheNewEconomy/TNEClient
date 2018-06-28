package com.creatorfromhell.tnemod;

import com.creatorfromhell.tnemod.item.TNETab;
import com.creatorfromhell.tnemod.network.TNEFinishRegisterMessage;
import com.creatorfromhell.tnemod.network.TNEModCheckMessage;
import com.creatorfromhell.tnemod.network.TNERegisterMessage;
import com.creatorfromhell.tnemod.proxy.CommonProxy;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

/**
 * Created by Daniel.
 *
 * The New Economy Client Mod
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0
 * International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */
@Mod(modid = TheNewEconomyMod.MODID, name = TheNewEconomyMod.NAME, version = TheNewEconomyMod.VERSION)
public class TheNewEconomyMod {
  public static final String MODID = "tnemod";
  public static final String NAME = "The New Economy Mod";
  public static final String VERSION = "0.1";

  private static Logger logger;

  @SidedProxy(serverSide = "com.creatorfromhell.tnemod.proxy.CommonProxy", clientSide = "com.creatorfromhell.tnemod.proxy.ClientProxy")
  public static CommonProxy proxy;

  public static final TNETab tab = new TNETab();
  public static final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);


  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
    wrapper.registerMessage(TNEModCheckMessage.Handler.class, TNEModCheckMessage.class, 120, Side.CLIENT);
    wrapper.registerMessage(TNERegisterMessage.Handler.class, TNERegisterMessage.class, 121, Side.CLIENT);
    wrapper.registerMessage(TNEFinishRegisterMessage.Handler.class, TNEFinishRegisterMessage.class, 122, Side.CLIENT);
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
  }

  public static byte[] readBytes(int length, ByteBuf buf) {
    byte[] array = new byte[length];

    for(int i = 0; i < length; i++) {
      array[i] = buf.readByte();
    }
    return array;
  }
}