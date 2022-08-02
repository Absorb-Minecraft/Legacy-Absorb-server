package org.absorb.inventory.action.click;

public interface ClickButtons {

    ClickButton LEFT = new ClickButtonBuilder()
            .setName("Left")
            .setNetworkId(0)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();

    ClickButton LEFT_OUTSIDE = new ClickButtonBuilder()
            .setName("Left")
            .setNetworkId(0)
            .setClickSlotType(ClickSlotType.OUTSIDE_SLOT)
            .build();
    ClickButton RIGHT = new ClickButtonBuilder()
            .setName("Right")
            .setNetworkId(1)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();

    ClickButton RIGHT_OUTSIDE = new ClickButtonBuilder()
            .setName("Right")
            .setNetworkId(1)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton MIDDLE = new ClickButtonBuilder()
            .setName("Middle")
            .setNetworkId(2)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton SHIFT_RIGHT = new ClickButtonBuilder()
            .setName("Right Shift")
            .setNetworkId(0)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton SHIFT_LEFT = new ClickButtonBuilder()
            .setName("Left Shift")
            .setNetworkId(1)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton NUMPAD_1 = new ClickButtonBuilder()
            .setName("Numpad 1")
            .setNetworkId(0)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton NUMPAD_2 = new ClickButtonBuilder()
            .setName("Numpad 2")
            .setNetworkId(1)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton NUMPAD_3 = new ClickButtonBuilder()
            .setName("Numpad 3")
            .setNetworkId(2)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton NUMPAD_4 = new ClickButtonBuilder()
            .setName("Numpad 4")
            .setNetworkId(3)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton NUMPAD_5 = new ClickButtonBuilder()
            .setName("Numpad 5")
            .setNetworkId(4)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton NUMPAD_6 = new ClickButtonBuilder()
            .setName("Numpad 6")
            .setNetworkId(5)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton NUMPAD_7 = new ClickButtonBuilder()
            .setName("Numpad 7")
            .setNetworkId(6)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton NUMPAD_8 = new ClickButtonBuilder()
            .setName("Numpad 8")
            .setNetworkId(7)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton NUMPAD_9 = new ClickButtonBuilder()
            .setName("Numpad 9")
            .setNetworkId(8)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton OFFHAND = new ClickButtonBuilder()
            .setName("Offhand")
            .setNetworkId(40)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build(); //press f
    ClickButton DROP = new ClickButtonBuilder()
            .setName("Drop")
            .setNetworkId(0)
            .setClickSlotType(ClickSlotType.NEVER)
            .build();
    ClickButton DROP_CTRL = new ClickButtonBuilder()
            .setName("Drop Ctrl")
            .setNetworkId(1)
            .setClickSlotType(ClickSlotType.NEVER)
            .build();
    ClickButton START_LEFT_DRAG = new ClickButtonBuilder()
            .setName("Start Drag Left")
            .setNetworkId(0)
            .setClickSlotType(ClickSlotType.OUTSIDE_SLOT)
            .build();
    ClickButton START_RIGHT_DRAG = new ClickButtonBuilder()
            .setName("Start Drag Right")
            .setNetworkId(4)
            .setClickSlotType(ClickSlotType.OUTSIDE_SLOT)
            .build();
    ClickButton START_MIDDLE_DRAG = new ClickButtonBuilder()
            .setName("Start Drag Middle")
            .setNetworkId(8)
            .setClickSlotType(ClickSlotType.OUTSIDE_SLOT)
            .build();
    ClickButton ADD_LEFT_DRAG = new ClickButtonBuilder()
            .setName("Add Drag Left")
            .setNetworkId(1)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton ADD_RIGHT_DRAG = new ClickButtonBuilder()
            .setName("Add Drag Right")
            .setNetworkId(5)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton ADD_MIDDLE_DRAG = new ClickButtonBuilder()
            .setName("Add Drag Middle")
            .setNetworkId(9)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();
    ClickButton END_LEFT_DRAG = new ClickButtonBuilder()
            .setName("End Drag Left")
            .setNetworkId(2)
            .setClickSlotType(ClickSlotType.OUTSIDE_SLOT)
            .build();
    ClickButton END_RIGHT_DRAG = new ClickButtonBuilder()
            .setName("End Drag Right")
            .setNetworkId(6)
            .setClickSlotType(ClickSlotType.OUTSIDE_SLOT)
            .build();
    ClickButton END_MIDDLE_DRAG = new ClickButtonBuilder()
            .setName("End Drag Middle")
            .setNetworkId(10)
            .setClickSlotType(ClickSlotType.OUTSIDE_SLOT)
            .build();
    ClickButton DOUBLE = new ClickButtonBuilder()
            .setName("Double")
            .setNetworkId(0)
            .setClickSlotType(ClickSlotType.REQUIRED_SLOT)
            .build();

}
