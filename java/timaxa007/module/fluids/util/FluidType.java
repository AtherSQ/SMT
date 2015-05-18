package timaxa007.module.fluids.util;

import net.minecraft.util.StatCollector;
import timaxa007.smt.util.UtilString;

public class FluidType {

	private String type;
	private float temperature_min;
	private float temperature_max;
	private int igniter;

	public FluidType(String type) {
		this.type = type;
		temperature_min = 0.0F;
		temperature_max = 0.0F;
		igniter = 0;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public FluidType setTemperatureMinMax(float min, float max) {
		temperature_min = min;
		temperature_max = max;
		return this;
	}

	public FluidType setTemperatureMin(float min) {
		temperature_min = min;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min;
	}

	public FluidType setTemperatureMax(float max) {
		temperature_max = max;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max;
	}

	/**If <b>zero</b>, then nothing. <br>
	 * If less than <b>zero</b>, it does not give ignite near flame or even extinguish. (<i>WIP</i>) <br>
	 * If greater than <b>zero</b>, then this object (block/entity/item) will burn. (<i>Half-WIP</i>)**/
	public FluidType setIgniter(int igniter) {
		this.igniter = igniter;
		return this;
	}

	public int getIgniter() {
		return igniter;
	}

	public String toString() {
		return "Fluid Type: " + getType() + ".";
	}

}