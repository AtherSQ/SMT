package mods.timaxa007.pack.stock.lib;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.UtilString;
import net.minecraft.util.StatCollector;
/**
 * Use in <b>ItemGerminationPlants</b> and <b>BlockGerminationPlants</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class GerminationPlants {

	public static final GerminationPlants[] list = new GerminationPlants[4096];

	public static final GerminationPlants empty = new GerminationPlants(0);

	public int id;
	public String tag;
	private String name;
	private String type;
	//private int color_hex;

	private int growth;
	private int fertility;
	private int resistance;

	private float temperature;
	private float temperature_min;
	private float temperature_max;

	private float humidity;
	private float humidity_min;
	private float humidity_max;

	private String texture;

	/**It is not recommended to use this method.**/
	@Deprecated
	public GerminationPlants() {
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public GerminationPlants(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public GerminationPlants(int id, String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
	}

	public GerminationPlants(String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		id = nextID();
		list[id] = this;
		this.tag = tag;
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
		return 0;
	}

	private static void checkTag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == tag)
				System.out.println("!Duplicate: " + tag);
	}

	public static GerminationPlants get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(GerminationPlants gp) {
		return gp == null || gp == empty;
	}
	//--------------------------------------------------------
	/*
	public int isTypeInt(String ttt) {
		switch (ttt) {
		case "Herbal":return 1;
		case "Flower":return 2;
		case "Crop":return 3;
		case "Crop Up":return 4;
		case "Mushroom":return 5;
		case "Stem":return 6;
		case "Squash":return 7;
		case "Shrub":return 8;
		case "Sapling":return 9;
		case "Tree":return 10;
		case "Palma":return 11;
		default:return 0;
		}
	}
	 */
	public String isTypeStr(int i) {
		switch(i) {
		case 1:return "Herbal";
		case 2:return "Flower";
		case 3:return "Crop";
		case 4:return "Crop Up";
		case 5:return "Mushroom";
		case 6:return "Stem";
		case 7:return "Squash";
		case 8:return "Shrub";
		case 9:return "Sapling";
		case 10:return "Tree";
		case 11:return "Palma";
		default:return "";
		}
	}

	public GerminationPlants setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("plant." + getName() + ".name");
	}

	public GerminationPlants setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}
	/*
	public GerminationPlants setColor(int i) {
		color_hex = i;
		return this;
	}

	public int getColor() {
		return color_hex == 0 ? 0xFFFFFF : color_hex;
	}
	 */
	public GerminationPlants setPlantStats(int gro, int fer, int res) {
		growth = gro;
		fertility = fer;
		resistance = res;
		return this;
	}

	public GerminationPlants setGrowth(int gro) {
		growth = gro;
		return this;
	}

	public int getGrowth() {
		return growth == 0 ? 0 : growth;
	}

	public GerminationPlants setFertility(int fer) {
		fertility = fer;
		return this;
	}

	public int getFertility() {
		return fertility == 0 ? 0 : fertility;
	}

	public GerminationPlants setResistance(int res) {
		resistance = res;
		return this;
	}

	public int getResistance() {
		return resistance == 0 ? 0 : resistance;
	}

	public GerminationPlants setTemperatures(float temp, float temp_min, float temp_max) {
		temperature = temp;
		temperature_min = temp_min;
		temperature_max = temp_max;
		return this;
	}

	public GerminationPlants setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature == 0 ? 0.0F : temperature;
	}

	public GerminationPlants setTemperatureMin(float f) {
		temperature_min = f;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min == 0 ? 0.0F : temperature_min;
	}

	public GerminationPlants setTemperatureMax(float f) {
		temperature_max = f;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max == 0 ? 0.0F : temperature_max;
	}

	public GerminationPlants setHumidity(float humy, float humy_min, float humy_max) {
		humidity = humy;
		humidity_min = humy_min;
		humidity_max = humy_max;
		return this;
	}

	public GerminationPlants setHumidity(float f) {
		humidity = f;
		return this;
	}

	public float getHumidity() {
		return humidity == 0 ? 0.0F : humidity;
	}

	public GerminationPlants setHumidityMin(float f) {
		humidity_min = f;
		return this;
	}

	public float getHumidityMin() {
		return humidity_min == 0 ? 0.0F : humidity_min;
	}

	public GerminationPlants setHumidityMax(float f) {
		humidity_max = f;
		return this;
	}

	public float getHumidityMax() {
		return humidity_max == 0 ? 0.0F : humidity_max;
	}

	public GerminationPlants setTexture(String str) {
		texture = str;
		return this;
	}

	public String getTexture() {
		return texture == null ? getName() : texture;
	}

}
