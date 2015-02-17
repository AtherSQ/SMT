package mods.timaxa007.pack.furniture.lib;

import mods.timaxa007.pack.magic.lib.Spells;
import mods.timaxa007.tms.util.UtilString;

/**
 * Use in <b>BlockCloth</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class AddBlockCloth {

	public static final AddBlockCloth[] list = new AddBlockCloth[127];

	public static final AddBlockCloth empty = new AddBlockCloth("");

	private int id;
	private String tag;
	private String name;
	private int color_hex;
	private String texture;

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockCloth() {id = nextID();list[id] = this;color_hex = 0xFFFFFF;}

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockCloth(int id) {
		checkID(this, id);this.id = id;list[id] = this;color_hex = 0xFFFFFF;
	}

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockCloth(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;color_hex = 0xFFFFFF;
	}

	public AddBlockCloth(String tag) {
		checkTag(this, tag);
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
		if (UtilString.hasString(tag))
			for (int i = 0; i < list.length; i++)
				if (list[i] != null && tag.equalsIgnoreCase(list[i].tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (int i = 0; i < list.length; i++)
				if (list[i] != null && tag.equalsIgnoreCase(list[i].tag))
					return i;
		return empty.id;
	}

	private static void checkID(AddBlockCloth addBlockCloth, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + addBlockCloth.getClass() + ".");
	}

	private static void checkTag(AddBlockCloth addBlockCloth, String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == tag)
				throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + addBlockCloth.getClass() + ".");
	}

	public static AddBlockCloth get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(AddBlockCloth addBlockCloth) {
		return addBlockCloth == null || addBlockCloth == empty;
	}
	//--------------------------------------------------------
	public AddBlockCloth setID(int id) {
		this.id = id;
		return this;
	}

	public int getID() {
		return id;
	}

	public AddBlockCloth setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public AddBlockCloth setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public AddBlockCloth setColor(int color) {
		color_hex = color;
		return this;
	}

	public int getColor() {
		return color_hex;
	}

	public AddBlockCloth setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture;
	}

}
