package com.creatorfromhell.tnemod.network;

import com.creatorfromhell.tnemod.TheNewEconomyMod;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TNERegisterMessage implements IMessage {
  /**
   * Convert from the supplied buffer into your specific message type
   */
  @Override
  public void fromBytes(ByteBuf buf) {
    final int length = buf.readInt();
    final String name = buf.readBytes(length).toString(StandardCharsets.UTF_8);
    final int textureLength = buf.readInt();
    BufferedImage image = null;
    try {
      image = ImageIO.read(new ByteArrayInputStream(TheNewEconomyMod.readBytes(textureLength, buf)));
    } catch(IOException e) {
      //failed
    }
    if(image != null) {
      try {
        ImageIO.write(image, "png", new File("./TheNewEconomy/" + name + ".png"));
      } catch(IOException e) {
        //failed
      }
    }
  }

  /**
   * Deconstruct your message into the supplied byte buffer
   */
  @Override
  public void toBytes(ByteBuf buf) {
  }

  public static class Handler implements IMessageHandler<TNERegisterMessage, IMessage> {

    /**
     * Called when a message is received of the appropriate type. You can optionally return a reply
     * message, or null if no reply is needed.
     *
     * @param message The message
     *
     * @return an optional return message
     */
    @Override
    public IMessage onMessage(TNERegisterMessage message, MessageContext ctx) {
      return null;
    }
  }
}