package me.odinclient.utils

import net.minecraft.network.Packet
import me.odinclient.OdinClient.Companion.mc

object PacketUtils {
    private val packets = ArrayList<Packet<*>>()

    fun handleSendPacket(packet: Packet<*>): Boolean {
        if (packets.contains(packet)) {
            packets.remove(packet)
            return true
        }
        return false
    }

    @JvmStatic
    fun sendPacketNoEvent(packet: Packet<*>) {
        packets.add(packet)
        mc.netHandler?.addToSendQueue(packet)
    }
}