package mods.timaxa007.pack.item.event;

import mods.timaxa007.pack.item.item.ToolShield;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventPackItems {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onShields�����(LivingHurtEvent e) {
		if (e.source instanceof EntityDamageSource) {
			EntityDamageSource dmgSource = (EntityDamageSource)e.source;
			Entity from = dmgSource.getEntity();//��� ������� ����,
			EntityLivingBase to = e.entityLiving;//���� ���������� ����,

			if (from instanceof EntityPlayer && to instanceof EntityPlayer) {
				//���� ��� ������� ���� ��������� ����� � ���� ���������� ���� ��������� �����, ��...

				EntityPlayer player_from = (EntityPlayer)from;
				ItemStack current_from = player_from.getCurrentEquippedItem();//��� ������� ��� ������� ����

				EntityPlayer player_to = (EntityPlayer)to;
				ItemStack current_to = player_to.getCurrentEquippedItem();//��� ������� ���� ��������� ����

				if (current_to != null && current_to.getItem() instanceof ToolShield && player_to.getItemInUseDuration() > 0) {
					//���� ���� ���� ���������� ����, ������� � ���������� ��� � ������� ���� ���
					e.ammount = 0;//����� ����
					if (current_from != null && current_from.getItem() instanceof ItemSword) {
						//���� ���� ��� ������� ���� �� �����, � ����� � ���� ���
						current_from.damageItem(((ToolShield)current_from.getItem()).getDamage(), player_from);
						//�� ������� ������� � ���� ����� �����������.
					}

				}

			}

		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
