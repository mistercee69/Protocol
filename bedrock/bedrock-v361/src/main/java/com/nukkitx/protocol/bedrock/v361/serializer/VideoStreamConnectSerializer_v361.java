package com.nukkitx.protocol.bedrock.v361.serializer;

import com.nukkitx.protocol.bedrock.BedrockPacketHelper;
import com.nukkitx.protocol.bedrock.BedrockPacketSerializer;
import com.nukkitx.protocol.bedrock.packet.VideoStreamConnectPacket;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VideoStreamConnectSerializer_v361 implements BedrockPacketSerializer<VideoStreamConnectPacket> {
    public static final VideoStreamConnectSerializer_v361 INSTANCE = new VideoStreamConnectSerializer_v361();

    @Override
    public void serialize(ByteBuf buffer, BedrockPacketHelper helper, VideoStreamConnectPacket packet) {
        helper.writeString(buffer, packet.getAddress());
        buffer.writeFloatLE(packet.getScreenshotFrequency());
        buffer.writeByte(packet.getAction().ordinal());
        buffer.writeIntLE(packet.getWidth());
        buffer.writeIntLE(packet.getHeight());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockPacketHelper helper, VideoStreamConnectPacket packet) {
        packet.setAddress(helper.readString(buffer));
        packet.setScreenshotFrequency(buffer.readFloatLE());
        packet.setAction(VideoStreamConnectPacket.Action.values()[buffer.readUnsignedByte()]);
        packet.setWidth(buffer.readIntLE());
        packet.setHeight(buffer.readIntLE());
    }
}
