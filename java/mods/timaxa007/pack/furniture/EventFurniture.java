package mods.timaxa007.pack.furniture;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventFurniture {
//--------------------------------------------------------------------------------------------------------------
@SubscribeEvent
public void addNewBottle(PlayerInteractEvent event) {
EntityPlayer player = event.entityPlayer;
World world = player.worldObj;
ItemStack current = player.getCurrentEquippedItem();
if (player != null && world != null && event.action == event.action.RIGHT_CLICK_BLOCK) {
if (current != null && current.getItem() == Items.glass_bottle && world.getBlock(event.x, event.y, event.z) == Blocks.stone) {
--current.stackSize;
//player.inventory.addItemStackToInventory(new ItemStack(PackStock.proxy.item_drinks, 1, 0));
event.setResult(Result.ALLOW);
}
}
}
//--------------------------------------------------------------------------------------------------------------
}