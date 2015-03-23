package timaxa007.pack.furniture.lib;

import timaxa007.tms.util.UtilString;

/**
 * Use in <b>BlockGround</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class AddBlockGround {

	public static final AddBlockGround[] list = new AddBlockGround[127];

	public static final AddBlockGround empty = new AddBlockGround("");

	private int id;
	private String tag;
	private String name;
	private int color_hex;
	private String texture;

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockGround() {id = nextID();list[id] = this;color_hex = 0xFFFFFF;}

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockGround(int id) {
		checkID(this, id);this.id = id;list[id] = this;color_hex = 0xFFFFFF;
	}

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockGround(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;color_hex = 0xFFFFFF;
	}

	public AddBlockGround(String tag) {
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
			for (AddBlockGround adding : list)
				if (adding != null && tag.equalsIgnoreCase(adding.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (AddBlockGround adding : list)
				if (adding != null && tag.equalsIgnoreCase(adding.tag))
					return adding.id;
		return empty.id;
	}

	private static void checkID(AddBlockGround addBlockGround, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + addBlockGround.getClass() + ".");
	}

	private static void checkTag(AddBlockGround addBlockGround, String tag) {
		for (AddBlockGround adding : list)
			if (adding != null && adding.tag == tag)
				throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + addBlockGround.getClass() + ".");
	}

	public static AddBlockGround get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(AddBlockGround addBlockGround) {
		return addBlockGround == null || addBlockGround == empty;
	}
	//--------------------------------------------------------
	public AddBlockGround setID(int id) {
		this.id = id;
		return this;
	}

	public int getID() {
		return id;
	}

	public AddBlockGround setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public AddBlockGround setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public AddBlockGround setColor(int color) {
		color_hex = color;
		return this;
	}

	public int getColor() {
		return color_hex;
	}

	public AddBlockGround setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture;
	}

}