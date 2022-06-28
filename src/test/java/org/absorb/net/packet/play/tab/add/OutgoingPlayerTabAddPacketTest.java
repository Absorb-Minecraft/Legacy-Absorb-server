package org.absorb.net.packet.play.tab.add;

public class OutgoingPlayerTabAddPacketTest {

    /*@Test
    public void testCanReadWritten() {
        UUID uuid = UUID.randomUUID();
        String name = "Test";
        int ping = 100;
        Gamemode mode = Gamemodes.CREATIVE;
        Client client;
        try {
            client = new Client(new Socket());
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail();
            return;
        }

        PlayerTab tab = new PlayerTabBuilder().setName(name).setPing(ping).setGameMode(mode).setUuid(uuid).build();

        OutgoingPlayerTabUpdateAddPlayerPacket tabPacket =
                new OutgoingPlayerTabUpdateAddPlayerPacketBuilder().addTabs(Collections.singleton(tab)).build();

        ByteBuffer buffer = tabPacket.toBytes(client);

        //assert

        NetEntryData<Integer> lengthBuffer = NetSerializers.VAR_INTEGER.read(0, buffer);
        NetEntryData<Integer> idBuffer = NetSerializers.VAR_INTEGER.read(lengthBuffer.endingPosition(), buffer);
        NetEntryData<Integer> actionBuffer = NetSerializers.VAR_INTEGER.read(idBuffer.endingPosition(), buffer);
        NetEntryData<Integer> sizeBuffer = NetSerializers.VAR_INTEGER.read(actionBuffer.endingPosition(), buffer);
        NetEntryData<UUID> uuidBuffer = NetSerializers.UUID.read(sizeBuffer.endingPosition(), buffer);
        NetEntryData<String> nameBuffer = NetSerializers.STRING.read(uuidBuffer.endingPosition(), buffer);
        NetEntryData<Integer> propertiesSizeBuffer = NetSerializers.VAR_INTEGER.read(nameBuffer.endingPosition(), buffer);
        NetEntryData<Integer> gamemodeBuffer = NetSerializers.VAR_INTEGER.read(propertiesSizeBuffer.endingPosition(),
                buffer);
        NetEntryData<Integer> pingBuffer = NetSerializers.VAR_INTEGER.read(gamemodeBuffer.endingPosition(), buffer);
        NetEntryData<Boolean> hasDisplayNameBuffer = NetSerializers.BOOLEAN.read(pingBuffer.endingPosition(), buffer);

        //assertion
        int currentLength = Arrays.copyOfRange(buffer.array(), lengthBuffer.endingPosition(), buffer.array().length).length;
        Assertions.assertEquals(currentLength, lengthBuffer.value());
        Assertions.assertEquals(uuid, uuidBuffer.value());
        Assertions.assertEquals(name, nameBuffer.value());
        Assertions.assertEquals(ping, pingBuffer.value());
        Assertions.assertEquals(mode.getNetworkId(), gamemodeBuffer.value());
        Assertions.assertFalse(hasDisplayNameBuffer.value());
    }*/
}
