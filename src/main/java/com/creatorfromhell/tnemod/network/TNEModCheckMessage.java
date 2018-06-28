package com.creatorfromhell.tnemod.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.nio.charset.StandardCharsets;

public class TNEModCheckMessage implements IMessage {

  private String uuid = "";
  /**
   * Convert from the supplied buffer into your specific message type
   */
  @Override
  public void fromBytes(ByteBuf buf) {
    int length = buf.readInt();
    uuid = buf.readBytes(length).toString(StandardCharsets.UTF_8);
  }

  /**
   * Deconstruct your message into the supplied byte buffer
   */
  @Override
  public void toBytes(ByteBuf buf) {
    ByteBufUtils.writeUTF8String(buf, uuid);
  }

  public static class Handler implements IMessageHandler<TNEModCheckMessage, IMessage> {

    /**
     * Called when a message is received of the appropriate type. You can optionally return a reply
     * message, or null if no reply is needed.
     *
     * @param message The message
     *
     * @return an optional return message
     */
    @Override
    public IMessage onMessage(TNEModCheckMessage message, MessageContext ctx) {
      if(ctx.side == Side.SERVER) {
        return new TNEModCheckMessage();
      }
      return null;
    }
  }
}