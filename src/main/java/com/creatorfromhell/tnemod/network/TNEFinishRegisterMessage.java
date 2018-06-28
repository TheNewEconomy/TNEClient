package com.creatorfromhell.tnemod.network;


import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class TNEFinishRegisterMessage implements IMessage {
  /**
   * Convert from the supplied buffer into your specific message type
   */
  @Override
  public void fromBytes(ByteBuf buf) {
    //TODO: Zip textures into a resource pack, and enable it.
  }

  /**
   * Deconstruct your message into the supplied byte buffer
   */
  @Override
  public void toBytes(ByteBuf buf) {
  }

  public static class Handler implements IMessageHandler<TNEFinishRegisterMessage, IMessage> {

    /**
     * Called when a message is received of the appropriate type. You can optionally return a reply
     * message, or null if no reply is needed.
     *
     * @param message The message
     *
     * @return an optional return message
     */
    @Override
    public IMessage onMessage(TNEFinishRegisterMessage message, MessageContext ctx) {
      return null;
    }
  }
}