package mods.timaxa007.pack.furniture.lib;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.UtilTMS;

/**
 * Use in <b>BlockWood</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class AddBlockWood {

	public static final AddBlockWood[] list = new AddBlockWood[127];

	private int id;
	private String tag;
	private String name;
	private int color_hex;
	private String texture;

	/**It is not recommended to use this method.**/
	@Deprecated
	public AddBlockWood() {
		id = nextID();
		list[id] = this;
		tag = "";
		color_hex = 0xFFFFFF;
		texture = "";
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AddBlockWood(int id) {
		this.id = id;
		list[id] = this;
		tag = "";
		color_hex = 0xFFFFFF;
		texture = "";
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AddBlockWood(int id, String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
		color_hex = 0xFFFFFF;
		texture = "";
	}

	public AddBlockWood(String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		id = nextID();
		list[id] = this;
		this.tag = tag;
		color_hex = 0xFFFFFF;
		texture = "";
	}
	//--------------------------------------------------------
	public static int nextID() {
		for (int i = 0; i < list.length; i++)
			if (list[i] == null)
				return i;
		return list.length - 1;
	}

	public static boolean hasTag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (tag.equalsIgnoreCase(list[i].tag))
				return true;
		return false;
	}

	public static int getID_tag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (tag.equalsIgnoreCase(list[i].tag))
				return i;
		return 0;
	}

	private static void checkTag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == tag)
				System.out.println("!Duplicate: " + tag);
	}

	public static AddBlockWood get(String tag) {
		if (UtilTMS.hasString(tag))
			return list[getID_tag(tag)];
		return list[0];
	}
	//--------------------------------------------------------
	public AddBlockWood setID(int id) {
		this.id = id;
		return this;
	}

	public int getID() {
		return id;
	}

	public AddBlockWood setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public AddBlockWood setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public AddBlockWood setColor(int color) {
		color_hex = color;
		return this;
	}

	public int getColor() {
		return color_hex;
	}

	public AddBlockWood setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture;
	}

}
