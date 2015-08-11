package timaxa007.gui.iinventory;

import net.minecraft.item.ItemStack;
import timaxa007.api.IItemStorage;

public class ListAccess {

	public static boolean blackForStorage(ItemStack is) {
		if (is != null) {
			//-----------------------------------------------------
			if (is.getItem() instanceof IItemStorage) return true;
			//-----------------------------------------------------
			// No - implements, Yes - extends
			//--forestry--"forestry.core.items.ItemInventoried" - это ещё включает всякие анализаторы.
			try {if (Class.forName("forestry.storage.items.ItemBackpack").isInstance(is.getItem())) return true;} catch(Exception e) {}
			//railcraft - он добавляет рюкзак с помощью forestry, так что не знаю.
			try {if (Class.forName("mods.railcraft.common.plugins.forestry.BaseBackpack").isInstance(is.getItem())) return true;} catch(Exception e) {}
			//Ранец не хранит в себе, он просто как апгрейд для игрока, но всё-же добавил. Скоро будет опциональна, как и всё другое.
			try {if (Class.forName("tconstruct.armor.items.Knapsack").isInstance(is.getItem())) return true;} catch(Exception e) {}
			//Дальше, просто по-поиску из import'ов
			try {if (Class.forName("de.eydamos.backpack.item.ItemBackpackBase").isInstance(is.getItem())) return true;} catch(Exception e) {}
			//-----------------------------------------------------
		}
		return false;
	}

	public static boolean black(ItemStack is) {
		return false;
	}

	public static boolean white(ItemStack is) {
		return false;
	}

	public static boolean other(ItemStack is) {
		return false;
	}

}
